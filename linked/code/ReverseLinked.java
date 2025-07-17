/**
 * @Author zhouxianwen
 * @Date 2025/7/17 18:54
 * @Description: 算法刷题-链表篇-反转链表
 */
public class ReverseLinked {

    /*题意：反转一个单链表。

    示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL*/

    public static void main(String[] args) {

    }

    // 双指针解法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // 递归
    public ListNode reverseList1(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }

    // 从后面递归
    ListNode reverseList3(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }
}
