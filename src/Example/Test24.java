package Example;
/**
 * @author Nouga
 *Date:2017/8/2
 *Delcaration : All Rights Reserved ! 
 */
public class Test24 {

	/**
	 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头结点。
	 * @author Nouga
	 */
	public static class ListNode {
		int value;
		ListNode next;
	}
	
	public static ListNode ReverseList2 (ListNode head){
		if (head == null){
			return null ;
		}
		
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
		}
		return reverseHead;
	}
	
}
 