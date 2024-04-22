#include <stdio.h>
#include <pthread.h>

#define MAX_CAPACITY 100
#define MAX_PRODUCER_OPERATIONS 5
#define MAX_CONSUMER_OPERATIONS 5

int shelf = 100; // 货架上的存货数量
pthread_mutex_t mutex; // 互斥锁
pthread_cond_t cond_producer, cond_consumer; // 条件变量
int producer_count = 0, consumer_count = 0; // 生产者和消费者操作计数

// 生产者线程函数
void* producer(void* arg) {
    int id = *(int*)arg;
    int operations = 0;

    while (operations < MAX_PRODUCER_OPERATIONS) {
        pthread_mutex_lock(&mutex); // 加锁

        // 如果货架已满，等待条件变量 cond_producer
        while (shelf >= MAX_CAPACITY) {
            printf("Producer %d: Shelf is full, waiting...\n", id);
            pthread_cond_wait(&cond_producer, &mutex);
        }

        // 生产并放入货架
        shelf += 40;
        printf("Producer %d: Produced 40 items, current shelf: %d\n", id, shelf);

        pthread_cond_signal(&cond_consumer); // 发送信号给消费者线程
        pthread_mutex_unlock(&mutex); // 解锁

        operations++;
    }

    return NULL;
}

// 消费者线程函数
void* consumer(void* arg) {
    int id = *(int*)arg;
    int operations = 0;

    while (operations < MAX_CONSUMER_OPERATIONS) {
        pthread_mutex_lock(&mutex); // 加锁

        // 如果货架为空，等待条件变量 cond_consumer
        while (shelf <= 0) {
            printf("Consumer %d: Shelf is empty, waiting...\n", id);
            pthread_cond_wait(&cond_consumer, &mutex);
        }

        // 取货并从货架上移除
        shelf -= 60;
        printf("Consumer %d: Consumed 60 items, current shelf: %d\n", id, shelf);

        pthread_cond_signal(&cond_producer); // 发送信号给生产者线程
        pthread_mutex_unlock(&mutex); // 解锁

        operations++;
    }

    return NULL;
}

int main() {
    pthread_t producer_thread, consumer_thread;
    int producer_id = 1, consumer_id = 1;

    pthread_mutex_init(&mutex, NULL);
    pthread_cond_init(&cond_producer, NULL);
    pthread_cond_init(&cond_consumer, NULL);

    // 创建生产者和消费者线程
    pthread_create(&producer_thread, NULL, producer, &producer_id);
    pthread_create(&consumer_thread, NULL, consumer, &consumer_id);

    // 等待线程结束
    pthread_join(producer_thread, NULL);
    pthread_join(consumer_thread, NULL);

    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&cond_producer);
    pthread_cond_destroy(&cond_consumer);

    return 0;
}
