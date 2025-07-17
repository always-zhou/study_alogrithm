/**
 * @Author zhouxianwen
 * @Date 2025/7/17 19:18
 * @Description: 算法刷题-链表篇-删除链表的倒数第N个节点
 */
public class RemoveNthFromEndLinked {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //新建一个虚拟头节点指向head
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        //快慢指针指向虚拟头节点
        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        // 只要快慢指针相差 n 个结点即可
        for (int i = 0; i <= n; i++) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        // 此时 slowIndex 的位置就是待删除元素的前一个位置。
        // 具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        // 检查 slowIndex.next 是否为 null，以避免空指针异常
        if (slowIndex.next != null) {
            slowIndex.next = slowIndex.next.next;
        }
        return dummyNode.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 创建一个新的哑节点，指向原链表头
        ListNode s = new ListNode(-1, head);
        // 递归调用remove方法，从哑节点开始进行删除操作
        remove(s, n);
        // 返回新链表的头（去掉可能的哑节点）
        return s.next;
    }

    public int remove(ListNode p, int n) {
        // 递归结束条件：如果当前节点为空，返回0
        if (p == null) {
            return 0;
        }
        // 递归深入到下一个节点
        int net = remove(p.next, n);
        // 如果当前节点是倒数第n个节点，进行删除操作
        if (net == n) {
            p.next = p.next.next;
        }
        // 返回当前节点的总深度
        return net + 1;
    }
}
