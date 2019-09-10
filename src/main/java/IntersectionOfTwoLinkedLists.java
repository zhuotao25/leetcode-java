import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists implements ISolution {

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    @Override
    public void showProblemDetails() {
        System.out.println("#[160] Intersection of Two Linked Lists");
        System.out.println("https://leetcode.com/problems/intersection-of-two-linked-lists/");
        System.out.println();
    }

    @Override
    public void execute() {
//        [4,1,8,4,5]
//        [5,0,1,8,4,5]
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode x = new ListNode(8);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        a1.next = a2;
        a2.next = x;
        x.next = a3;
        a3.next = a4;
        b1.next = b2;
        b2.next = b3;
        b3.next = x;

        System.out.println("Input: [4,1,*8,*4,*5], [5,0,1,*8,*4,*5]");
        ListNode output = getIntersectionNode(a1, b1);
        System.out.println("Output: " + output.val);
    }
}
