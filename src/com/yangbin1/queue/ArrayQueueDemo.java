package com.yangbin1.queue;

public class ArrayQueueDemo {

    public static void main(String[] args) {

    }
}

//使用数组模拟队列 - 编写ArrayQueue类

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr; //数组存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxsize) {
        this.maxSize = arrMaxsize;
        arr = new int[maxSize];
        front = -1; //只想队列头部，队列头的前一个位置
        rear = -1;//指向队列尾，指向列尾的数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = n;
    }

    //数据出队列
    public int getQueue() {
        //判断队列是否满
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头部
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

}

