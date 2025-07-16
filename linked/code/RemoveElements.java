import java.util.LinkedList;
import java.util.List;

/**
 * @Author zhouxianwen
 * @Date 2025/7/16 14:27
 * @Description: 算法刷题-链表篇-移除元素
 */
public class RemoveElements {

    /*题意：删除链表中等于给定值 val 的所有节点。

    示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]

    示例 2： 输入：head = [], val = 1 输出：[]

    示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
    */
    public static void main(String[] args) {
        // 两种创建链表的方法：第一种，手动维护，用于算法题
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        // 根据自定义的链表中，链式赋值
        ListNode head2 = new ListNode(1);
        head2.setNext(new ListNode(2))
                .setNext(new ListNode(6))
                .setNext(new ListNode(3))
                .setNext(new ListNode(4))
                .setNext(new ListNode(5))
                .setNext(new ListNode(6));

        // 根据自定义的链表中的of方法
        ListNode head3 = ListNode.of(1,2,6,3,4,5,6);


        // 第二种，使用LinkedList 是根据双向列表实现的
        LinkedList<Integer> head1 = new LinkedList<>();
        head1.add(1);
        head1.add(2);
        head1.add(6);
        head1.add(3);
        head1.add(4);
        head1.add(5);
        head1.add(6);

//        System.out.println(method02(head, 6).toString());
        System.out.println(method03(head, 6).toString());
//        System.out.println(method01(head2, 6).toString());
//        System.out.println(method01(head3, 6).toString());
    }


    // 第一种方法：在原有的链表移除
    // 记得区分是否是头节点这个节点 分别处理
    public static ListNode method01(ListNode head, int val) {

        // 先排除头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else  {
                cur = cur.next;
            }
        }
        return head;

    }




    // 第二种方法：添加一个虚拟头节点，返回的时候记得把虚拟头节点移除
    public static ListNode method02(ListNode head, int val) {

        // 定义一个虚拟头点
        ListNode zeroNode = new ListNode(0);
        zeroNode.next = head;
        ListNode cur = zeroNode;
        while (  cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else  {
                cur = cur.next;
            }
        }
        return zeroNode.next;

    }

    // 第三种方法：递归（从尾部重新搭建链表）

    public static ListNode method03(ListNode head, int val){
        if (head == null) {
            return null;
        }
        head.next = method03(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
