package com.yangbin1.linkedList;

/**
 * @ClassName: Josephu
 * @Auther: yangbin1
 * @Date: 2019/8/18 21:23
 * @Description:
 */
public class Josephu {

    public static void main(String[] args) {

    }
}

class CircleSingleLinkedList {
    //first节点，没有编号
    private Boy first = null;

    //添加小孩节点，构成环形列表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针
        for (int i = 1; i < nums; i++) {
            //根据编号，创建节点
            Boy boy = new Boy(i);
            //如果是第一个
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first; //让cur指向第一个
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        //判断是否为空
        if (first == null) {
            System.out.println("没有数据");
            return;
        }
        Boy curBoy = first; //辅助指针
        while (true) {
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {//说明遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}


class Boy {
    private int no; //编号
    private Boy next; //下个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}