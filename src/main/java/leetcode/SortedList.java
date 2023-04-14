package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangrucheng on 2023/4/12
 */
class ListNode {
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

public class SortedList {

    public ListNode sortList(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }

        return process(head, p);
    }

    private static ListNode process(ListNode left, ListNode right) {
        System.out.println("before " + left.val + " " + right.val);

        if (left == null || right == null) {
            return left;
        }
        if (left == right) {
            return left;
        }
        System.out.println("after" + left.val + " " + right.val);
        ListNode fast = left, slow = left;
        while (fast != right && fast != null && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rightNext = right.next;
        right.next = null;

        ListNode l = process(left, slow);
        ListNode r = process(slow.next, right);
        List<ListNode> ans = merge(l, slow, r);
        ListNode h = ans.get(0);
        ListNode tail = ans.get(1);

        tail.next = rightNext;
        return h;
    }

    private static List<ListNode> merge(ListNode left, ListNode mid, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode l = left, r = mid;
        ListNode p = dummyHead;
        while (l != mid && r != right) {
            if (l.val <= r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }

        while (l != mid) {
            p.next = l;
            l = l.next;
            p = p.next;
        }

        while (r != right) {
            p.next = r;
            r = r.next;
            p = p.next;
        }
        List<ListNode> list = new ArrayList<>();
        list.add(dummyHead.next);
        list.add(p);
        return list;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode h = new ListNode(4, l3);
        ListNode p = h;
        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        ListNode listNode = new SortedList().sortList(h);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> objects = new ArrayList<>();

    }
}
