package com.yangbin1.linkedList;

/**
 * @ClassName: SingleLinkedList
 * @Auther: yangbin1
 * @Date: 2019/8/9 10:43
 * @Description:
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //创建节点
        HeroNode heroNode = new HeroNode(1, "songjiang", "jishiyu");
    }

    //定义SingleLinkedList管理节点
    class SingleLinkedList {
        //初始化头节点,不存放具体数据
        private HeroNode head = new HeroNode(0, "", "");

        //添加节点到单向链表
        //找到最后的节点，将最后的节点next指向新的节点
        public void add(HeroNode heroNode) {

            //辅助节点temp
            HeroNode temp = head;
            //遍历链表，找到最后
            while (true) {
                //找到链表的最后
                if (temp.next == null){
                    break;
                }
                //没有找到后移
                temp = temp.next;
            }
            //退出while循环，指向链表最后
            temp.next = heroNode;
        }

        //显示链表(遍历）
        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //辅助变量
            HeroNode temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }
                //输出节点信息
                System.out.println(temp);
                //将temp后移
                temp = temp.next;
            }
        }
    }

    class HeroNode {
        public int no;
        public String name;
        public String nickname;
        public HeroNode next; //指向下一个节点

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
