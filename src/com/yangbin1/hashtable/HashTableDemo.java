package com.yangbin1.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {

    }

    class HashTab {
        private EmpLinkedList[] empLinkedListArray;
        private int size;

        //构造器
        public HashTab(int size) {
            this.size = size;
            empLinkedListArray = new EmpLinkedList[size];
        }

        public void add(Emp emp) {
            //根据员工id决定在哪个链表
            int empLinkedListNo = hashFun(emp.id);
            //将emp添加到链表
            empLinkedListArray[empLinkedListNo].add(emp);

        }

        public void list() {
            for (int i = 0; i < size; i++) {
                empLinkedListArray[i].list();
            }
        }

        public int hashFun(int id) {
            return id % size;
        }
    }

    //表示一个雇员
    class Emp {
        public int id;
        public String name;
        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    class EmpLinkedList {
        //头指针
        private Emp head;

        //添加到链表尾部
        public void add(Emp emp) {
            //添加到第一个
            if (head == null) {
                head = emp;
                return;
            }
            //如果不是第一个
            Emp curEmp = head;
            while (true) {
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            //退出时将emp放入链表尾部
            curEmp.next = emp;
        }

        //遍历链表
        public void list() {
            if (head == null) {
                System.out.println("当前链表为空");
                return;
            }
            System.out.println("当前链表信息为");
            Emp curEmp = head; //辅助指针
            while (true) {
                System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            System.out.println();
        }

    }
}
