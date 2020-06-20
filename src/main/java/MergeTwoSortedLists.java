import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists implements ISolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while(l1!=null||l2!=null) {
            int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (v1>=v2) {
                curr.next = l2;
                l2 = l2 == null ? null: l2.next;

            } else {
                curr.next = l1;
                l1 = l1 == null ? null: l1.next;
            }
            curr = curr.next;
        }
        return head.next;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[21] Merge Two Sorted Lists");
        System.out.println("https://leetcode.com/problems/merge-two-sorted-lists/");
        System.out.println();
    }

    @Override
    public void execute() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;

        ListNode result = mergeTwoLists(a1, b1);
        List<Integer> values = new ArrayList<>();
        while(result != null) {
            values.add(result.val);
            result = result.next;
        }
        System.out.println(values);
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
