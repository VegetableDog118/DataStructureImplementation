package LinkedList;

import java.util.List;

/*
删除链表中等于给定值 val 的所有节点。

        示例:

        输入: 1->2->6->3->4->5->6, val = 6
        输出: 1->2->3->4->5

 */
public class LeetCode203_1 {
    public ListNode removeElements(ListNode head, int val) {
        //先看头节点是否需要被删除
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null){
            return null;
        }

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node = (new LeetCode203_1()).removeElements(head,6);
        System.out.println(node);


    }
}


