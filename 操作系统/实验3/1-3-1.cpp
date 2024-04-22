#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <unistd.h>

typedef struct {
    char name[4];
    int age;
} people;  // 定义一个people结构体

int main(int argc, char** argv) {
    int fd, i;
    people* p_map;
    short temp;                                             // 将temp变量的类型改为short，大小为2字节
    fd = open(argv[1], O_CREAT | O_RDWR | O_TRUNC, 00777);  // 打开或创建一个文件，大小为5个people结构体的大小
    lseek(fd, sizeof(people) * 5 - 1, SEEK_SET);            // 改变文件读写指针位置
    write(fd, "", 1);                                       // 写入一个字节作为文件内容，使文件大小达到5个people结构体的大小
    p_map = (people*)mmap(NULL, sizeof(people) * 10, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);  // 将文件映射到内存，初始化为10个people数据结构大小
    if (p_map == MAP_FAILED) {
        perror("mmap");
        return -1;
    }
    close(fd);
    temp = 'a';  // 赋初值
    for (i = 0; i < 10; i++) {
        temp += 1;
        memcpy((*(p_map + i)).name, &temp, 1);  // 使用1作为拷贝大小
        (*(p_map + i)).age = 20 + i;
    }
    printf("initialize over\n");
    sleep(10);                           // 进程睡眠10s，等待其它进程映射同一个文件
    munmap(p_map, sizeof(people) * 10);  // 在进程地址空间中解除一个映射关系
    printf("umap ok\n");
    return 0;
}
