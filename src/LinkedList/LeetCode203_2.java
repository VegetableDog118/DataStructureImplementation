package LinkedList;

import java.util.List;

public class LeetCode203_2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        System.out.println(head.val);
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
               prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node = (new LeetCode203_2()).removeElements(head,6);
        System.out.println(node);
    }
}

