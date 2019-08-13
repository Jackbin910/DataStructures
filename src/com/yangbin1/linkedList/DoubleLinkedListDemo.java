package com.yangbin1.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        System.out.println("双向链表测试");
        HeroNode2 heroNode1 = new HeroNode2(1, "songjiang", "jishiyu");
        HeroNode2 heroNode2 = new HeroNode2(2, "lujunyi", "yuqiling");
        HeroNode2 heroNode3 = new HeroNode2(3, "wuyong", "zhiduoxing");
        HeroNode2 heroNode4 = new HeroNode2(4, "linchong", "baozitou");

        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4, "gongsunsheng", "ruyunlong");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表");
        doubleLinkedList.list();
    }
}

//定义SingleLinkedList管理节点
class DoubleLinkedList {
    //初始化头节点,不存放具体数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //添加节点到双向链表最后
    public void add(HeroNode2 heroNode) {

        //辅助节点temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //没有找到后移
            temp = temp.next;
        }
        //退出while循环，
        //形成一个双向链表
        temp.next = heroNode;
        //防止越界
        if (temp.next != null) {
            heroNode.prev = temp;
        }
    }

    //根据no修改节点信息
    public void update(HeroNode2 newHeroNode) {
        //判断是否是空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; //遍历结束
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag,判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            // 没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    public void del(int no) {
        //判断当前是否是空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false; //是否找到节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //删除
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }

    }

    //显示链表(遍历）
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //辅助变量
        HeroNode2 temp = head.next;
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

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 prev; //指向上一个节点

    public HeroNode2(int no, String name, String nickname) {
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
                '}';
    }
}
