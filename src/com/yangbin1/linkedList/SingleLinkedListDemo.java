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
        HeroNode heroNode1 = new HeroNode(1, "songjiang", "jishiyu");
        HeroNode heroNode2 = new HeroNode(2, "lujunyi", "yuqiling");
        HeroNode heroNode3 = new HeroNode(3, "wuyong", "zhiduoxing");
        HeroNode heroNode4 = new HeroNode(4, "linchong", "baozitou");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);

        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "xiaolu", "yuqiling~~");
        singleLinkedList.update(newHeroNode);

        //显示
        System.out.println("修改后");
        singleLinkedList.list();

        //删除
        singleLinkedList.del(1);
        System.out.println("删除后");
        singleLinkedList.list();

        //节点个数
        System.out.println(getLength(singleLinkedList.getHead()));

    }

    //获取节点个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

//定义SingleLinkedList管理节点
class SingleLinkedList {
    //初始化头节点,不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //找到最后的节点，将最后的节点next指向新的节点
    public void add(HeroNode heroNode) {

        //辅助节点temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //没有找到后移
            temp = temp.next;
        }
        //退出while循环，指向链表最后
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//标识编号是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，在temp后插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明添加的heroNode的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入英雄的编号%d 已经存在，不能加入\n", heroNode.no);
        } else {
            //插入链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;

        }
    }

    //根据no修改节点信息
    public void update(HeroNode newHeroNode) {
        //判断是否是空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no
        HeroNode temp = head.next;
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
        HeroNode temp = head;
        boolean flag = false; //是否找到
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //删除
            temp.next = temp.next.next;
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
                '}';
    }
}

