package LinkedList;

public class LeetCode203_3 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        if(head.val == val){
            return removeElements(head.next , val);
        }else{
            head.next = removeElements(head.next , val);
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node = (new LeetCode203_3()).removeElements(head,6);
        System.out.println(node);
    }
}
