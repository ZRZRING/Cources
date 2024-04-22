#include <stdio.h>
#include <pthread.h> 
#include <unistd.h> 
 
#define MAX_READERS 5 
#define MAX_WRITERS 2 
 
pthread_mutex_t mutex;          // 互斥锁，用于对共享资源的访问控制 
pthread_cond_t cond_reader;     // 读者条件变量，用于读者线程之间的同步 
pthread_cond_t cond_writer;     // 写者条件变量，用于写者线程之间的同步 
 
int readers = 0;               // 当前读者数量 
int writers = 0;               // 当前写者数量 
int data = 0;                  // 共享资源 
 
void *reader(void *arg) { 
    int id = *((int *)arg); 
    while (1) { 
        // 进入读临界区前先获取互斥锁 
        pthread_mutex_lock(&mutex); 
        while (writers > 0) { 
            // 如果有写者在写，则等待写者完成 
            pthread_cond_wait(&cond_reader, &mutex); 
        } 
        readers++; 
        pthread_mutex_unlock(&mutex); 
 
        // 读取共享资源 
        printf("Reader %d reads data: %d\n", id, data); 
 
        // 离开读临界区前获取互斥锁 
        pthread_mutex_lock(&mutex); 
        readers--; 
        if (readers == 0) { 
            // 如果没有读者了，则唤醒所有写者 
            pthread_cond_broadcast(&cond_writer); 
        } 
        pthread_mutex_unlock(&mutex); 
 
        // 休眠一段时间 
        sleep(1); 
    } 
    return NULL; 
} 
 
void *writer(void *arg) { 
    int id = *((int *)arg); 
    while (1) { 
        // 进入写临界区前先获取互斥锁 
        pthread_mutex_lock(&mutex); 
        while (readers > 0 || writers > 0) { 
            // 如果有读者在读或者有其他写者在写，则等待 
            pthread_cond_wait(&cond_writer, &mutex); 
        } 
        writers++; 
        pthread_mutex_unlock(&mutex); 
 
        // 写入共享资源 
        data++; 
        printf("Writer %d writes data: %d\n", id, data); 
 
        // 离开写临界区前获取互斥锁 
        pthread_mutex_lock(&mutex); 
        writers--; 
        pthread_cond_broadcast(&cond_reader); // 唤醒所有读者 
        pthread_cond_signal(&cond_writer);     // 唤醒一个写者 
        pthread_mutex_unlock(&mutex); 
 
        // 休眠一段时间 
        sleep(1); 
    } 
    return NULL; 
} 
int main() { 
    pthread_t readers[MAX_READERS]; 
    pthread_t writers[MAX_WRITERS]; 
    int reader_ids[MAX_READERS]; 
    int writer_ids[MAX_WRITERS]; 
 
    // 初始化互斥锁和条件变量 
    pthread_mutex_init(&mutex, NULL); 
    pthread_cond_init(&cond_reader, NULL); 
    pthread_cond_init(&cond_writer, NULL); 
 
    // 创建读者线程 
    for (int i = 0; i < MAX_READERS; i++) { 
        reader_ids[i] = i + 1; 
        pthread_create(&readers[i], NULL, reader, &reader_ids[i]); 
    } 
 
    // 创建写者线程 
    for (int i = 0; i < MAX_WRITERS; i++) { 
        writer_ids[i] = i + 1; 
        pthread_create(&writers[i], NULL, writer, &writer_ids[i]); 
    } 
 
    // 等待所有读者线程和写者线程结束 
    for (int i = 0; i < MAX_READERS; i++) { 
        pthread_join(readers[i], NULL); 
    } 
    for (int i = 0; i < MAX_WRITERS; i++) { 
        pthread_join(writers[i], NULL); 
    } 
 
    // 销毁互斥锁和条件变量 
    pthread_mutex_destroy(&mutex); 
    pthread_cond_destroy(&cond_reader); 
    pthread_cond_destroy(&cond_writer); 
 
    return 0; 
} 