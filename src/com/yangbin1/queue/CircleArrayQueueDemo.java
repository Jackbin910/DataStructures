package com.yangbin1.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        {
            //测试
            CircleArrayQueue queue = new CircleArrayQueue(3);
            char key = ' ';
            Scanner scanner = new Scanner(System.in);
            boolean loop = true;
            //输出一个菜单
            while (loop) {
                System.out.println("s(show):显示队列");
                System.out.println("e(exit):退出程序");
                System.out.println("a(add):添加数据到队列");
                System.out.println("g(get):从队列中取出数据");
                System.out.println("h(head):查看队列头的数据");
                key = scanner.next().charAt(0);//接收一个字符
                switch (key) {
                    case 's':
                        queue.showQueue();
                        break;
                    case 'a':
                        System.out.println("请输入一个值");
                        int value = scanner.nextInt();
                        queue.addQueue(value);
                        break;
                    case 'g':
                        try {
                            int res = queue.getQueue();
                            System.out.printf("取出的数据是%d\n", res);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 'h':
                        try {
                            int res = queue.headQueue();
                            System.out.printf("队列头的的数据是%d\n", res);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 'e':
                        scanner.close();
                        loop = false;
                        break;
                    default:
                        break;
                }
            }
            System.out.println("程序退出");
        }
    }
}


//使用数组模拟队列 - CircleArrayQueue
class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr; //数组存放数据，模拟队列

    //创建队列的构造器
    public CircleArrayQueue(int arrMaxsize) {
        this.maxSize = arrMaxsize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;
        //将rear后移，考虑取模
        rear = (rear + 1) % maxSize;
    }

    //数据出队列
    public int getQueue() {
        //判断队列是否满
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        //1.front对应的保存到一个临时变量
        //2.front 后移
        //3.临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效的数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头部
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

}