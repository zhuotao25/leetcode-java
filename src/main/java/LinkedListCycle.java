public class LinkedListCycle implements ISolution {

    private boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (slow.next == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[141] Linked List Cycle");
        System.out.println("https://leetcode.com/problems/linked-list-cycle/");
        System.out.println();
    }

    @Override
    public void execute() {
        // Input: head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(-4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = a;

        boolean output = hasCycle(head);
        System.out.println("Input: head = [3,2,0,-4], pos = 1");
        System.out.println("Output: " + output);
    }
}
