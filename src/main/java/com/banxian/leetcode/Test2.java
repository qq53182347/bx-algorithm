package com.banxian.leetcode;


/**
 2. 两数相加
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Test2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.val=2;
        node1.next=node2;
        node2.val=4;
        node2.next=node3;
        node3.val=3;


        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        node4.val=5;
        node4.next=node5;
        node5.val=6;
        node5.next=node6;
        node6.val=4;


        ListNode listNode = addTwoNumbers(node1, node4);
        System.out.println(listNode);
    }

    /**
     *
     由于链表是逆序存储，因此链表第一个节点就是最低位，需要从两个链表的头节点开始相加。
     对两个链表同时进行遍历，对两个链表的节点值相加，需要考虑上一次计算的进位问题。
     如果两个链表都遍历完了，仍存在进位，则需要在链表后添加一个节点。

     将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
     每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
     小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。

     作者：guanpengchn
     链接：https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode newHead  = new ListNode(0);
        ListNode cursor = newHead ;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            cursor.next = new ListNode(sumVal % 10);
            cursor = cursor.next ;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return newHead.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return null;
        }

        int sum = 0;
        ListNode result = new ListNode();
        ListNode cur_List = result;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            cur_List.next = new ListNode( sum%10);
            cur_List = cur_List.next;
            sum = sum / 10;
        }

        if (sum == 1) {
            cur_List.next = new ListNode(1);
        }

        return result.next;
    }



}