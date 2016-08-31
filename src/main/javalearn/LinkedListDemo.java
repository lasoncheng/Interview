package javalearn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lason on 7/12/16.
 *
 */
public class LinkedListDemo <T>{
    public ListNode root;
    public int len;

    public LinkedListDemo(){
        this.root = null;
        this.len = 0;
    }

    public void addValue(T value){
        //new node for linkedlist.
        ListNode pNew = new ListNode(value);
        pNew.next = null;
        if(this.root == null)
            this.root = pNew;
        else {
           ListNode pNode = this.root;
            while(pNode.next != null)
                pNode = pNode.next;
            pNode.next = pNew;
        }
        this.len++;
    }

    public boolean findValue(T value){
        ListNode pNode = this.root;
        while(pNode != null) {
            if(pNode.value.equals(value))
                return true;
            pNode = pNode.next;
        }
        return false;
    }

    //reverse LinkedList (recursive and non-recursive)
    public void  reverseList(){
        ListNode pHead = this.root;
        this.root = null;
        while(pHead != null){
            ListNode tmp = null;
            tmp = pHead;
            pHead = pHead.next;
            tmp.next = this.root;
            this.root = tmp;
        }
    }


    public ListNode reverseListByRecursive(ListNode pHead){
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode newHead = reverseListByRecursive(pHead.next);
        pHead.next.next = pHead;
        pHead.next = null;
        return newHead;
    }


    // the struct node for LinkedList.
    private static class ListNode <T> {
        T  value ;
        ListNode next;
        ListNode(T x){ value = x ;}
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        //set head point
        ListNode head;
        if((int) list1.value < (int)list2.value){
            head = list1;
            list1 = list1.next;
        }
        else{
            head = list2;
            list2 = list2.next;
        }
        //head.next = null;
        ListNode tmp = head;
        while(list1 != null && list2 != null){
            if((int) list1.value < (int) list2.value){
                tmp.next = list1;
                list1 = list1.next;
            }
            else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
            tmp.next = null;
        }

        if(list1 != null)
            tmp.next = list1;

        if(list2 != null)
            tmp.next = list2;
        return head;
    }

    public static void main(String []args){

        //define LinkedList by myself.
        LinkedListDemo <Integer> linkDemo1 = new LinkedListDemo ();
        linkDemo1.addValue(1);
        linkDemo1.addValue(3);
        linkDemo1.addValue(5);

        LinkedListDemo <Integer> linkDemo2 = new LinkedListDemo ();
        linkDemo2.addValue(2);
        linkDemo2.addValue(4);
        linkDemo2.addValue(6);
        ListNode head = LinkedListDemo.Merge(linkDemo1.root, linkDemo2.root);
        char []a = {'a','b'};
        System.out.println(a.toString());
        StringBuilder s = new StringBuilder();
        s.append('a');

    }
}


