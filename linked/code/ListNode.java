/**
 * @Author zhouxianwen
 * @Date 2025/7/16 14:40
 * @Description: 自定义链表
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // 链式赋值（返回 this，方便连续设置 next）
    ListNode setNext(ListNode next) {
        this.next = next;
        return next; // 返回 next，方便继续链式调用
    }

    // 静态方法：快速构建链表（可变参数）
    public static ListNode of(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        return sb.toString();
    }
}
