package Example;
/**
 * @author 85268
 *Date:7/14	
 *Declaration: All Rights Reserved !!
 */
public class Test18DelNode {
	public static void main(String[] args) {
		ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.value = 12;

        head = deleteNode(head, head); // 删除头结点
        printList(head);
        head = deleteNode(head, last); // 删除尾结点
        printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        printList(head);

        head = deleteNode(head, node); // 删除的结点不在链表中
        printList(head);
	}
	
	/**
	 * 链表节点
	 * @author 85268
	 *
	 */
	public static class ListNode{
		int value;	//Value
		ListNode next;//Next Node
	}
	
	/**
	 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点
	 * 【注意1：这个方法和文本上不一样，书上没有返回值，这个因为Java引用传递的原因。】
	 * 如果删除的节点是头节点，如果不采用返回值的方式，那么头节点永远删除不了。
	 * 【注意2：输入的待删除节点必须是待链表中的节点，否则会引起错误，这个条件由用户进行保证。】
	 * @param head	链表头
	 * @param toBeDeleted 待删除的节点
	 * @return 删除后的头节点
	 */
	public static ListNode deleteNode(ListNode head,ListNode toBeDeleted){
		//输入参数有空值，返回表头节点
		if(head == null || toBeDeleted == null ){
			return head;
		}
		//如果删除的是头节点，直接返回节点的下一个节点
		if(head == toBeDeleted){
			return head.next;
		}
		//下面的情况链表至少有两个节点
		//多节点的情况下，如果删除的是最后一个元素
		if(toBeDeleted.next == null){
			ListNode tmp = head; 
			//找待删除的元素的前驱
			while(tmp.next != toBeDeleted){
				tmp = tmp.next;
			}
			//删除待节点
			tmp.next = null;
		}
		//在多个节点的情况下，如果删除的是某个中间节点
		else{
			//将下一个节点的值输入当前待删除的节点
			toBeDeleted.value = toBeDeleted.next.value;
			//待删除的节点的下一个指向原来待删除引号的下下个节点，即将待删除的下一个节点删除
			toBeDeleted.next = toBeDeleted.next.next;
		}
		
		return head;
	}
	
	/**
	 * 输出链表的元素值
	 * @param head
	 */
	public static void printList(ListNode head){
		while(head != null){
			System.out.print(head.value + "--");
		}
		System.out.println("null");
	}
	
}
