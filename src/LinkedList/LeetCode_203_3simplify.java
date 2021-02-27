package LinkedList;

public class LeetCode_203_3simplify {
    public ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return null;
        }
        head.next = removeElements(head.next , val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node = (new LeetCode_203_3simplify()).removeElements(head,6);
        System.out.println(node);
    }
}
