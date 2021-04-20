package geekTime.list;

public class OddEvenList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, odd = new ListNode(0), oddHead = odd, even = new ListNode(0), evenHead = even;
        int count = 0;
        while (p != null) {
            count++;
            if (count % 2 == 1) {
                odd.next = p;
                odd = odd.next;
            } else {
                even.next = p;
                even = even.next;
            }
            p = p.next;
        }

        even.next = null;

        odd.next = evenHead.next;

        return oddHead.next;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p1 = l1, p2 = l2, head = result;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                result.next = p1;
                p1 = p1.next;
            } else {
                result.next = p2;
                p2 = p2.next;
            }
            result = result.next;
        }
        while (p1 != null) {
            result.next = p1;
            p1 = p1.next;
            result = result.next;
        }

        while (p2 != null) {
            result.next = p2;
            p2 = p2.next;
            result = result.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode node4 = new ListNode(4, tail);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        OddEvenList oddEvenList = new OddEvenList();
        ListNode node = oddEvenList.oddEvenList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
