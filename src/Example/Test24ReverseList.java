package Example;
/**
 * @author Nouga
 *Date:2017/8/2
 *Delcaration : All Rights Reserved ! 
 */
public class Test24ReverseList {

	/**
	 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头结点。
	 * @author Nouga
	 */
	public static class ListNode {
		int value;
		ListNode next;
	}
	
	public static ListNode ReverseList2 (ListNode head) {
		if (head == null){
			return null ;
		}
		//反转后的链表
		ListNode reverseHead = null ;
		//指针1：当前节点
		ListNode currentNode = head ;
		//指针2:当前节点的前一个节点
		ListNode prevNode = null ;
		while(currentNode != null ){
			ListNode nextNode = currentNode.next;
			if(nextNode == null ){
				reverseHead = currentNode;
			}
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
			System.out.println(currentNode.value);
		}
		return reverseHead;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode();
		node1.value = 1;
		ListNode node2 = new ListNode();
		node2.value = 2;
		ListNode node3 = new ListNode();
		node3.value = 3;
		ListNode node4 = new ListNode();
		node4.value = 4;
		ListNode node5 = new ListNode();
		node5.value = 5;
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ReverseList2(node1);
	}
}
 