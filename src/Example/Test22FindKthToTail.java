package Example;
/**
 * @author Nouga
 *Declaration: All Rights Reserved !
 *Date : 7/26 
 */
public class Test22FindKthToTail {

	/**
	 * 题目：输入一个链表，输出该链表中倒数第K个节点。
	 * 链表尾节点是第一个节点。
	 */
	
	/**
	 * @param head 链表的头节点
	 * @param k	倒数第K个节点
	 * @return	倒数第K个节点
	 */
	public static ListNode findKthToTail(ListNode head, int k){
		//输入的链表不能为空，并且K大于0
		if(k<1 || head == null ){
			return null ;
		}
		
		//指向头节点
		ListNode pointer = head ;
		
		//因为倒数K节点与倒数第一个节点相隔k-1个位置
		for (int i = 0; i < k; i++) {
			//说明还有节点
			if(pointer.next != null ){
				pointer = pointer.next;
			}
			//已经没有节点了，但是i还没有到k-1说明k太大，链表中没有那么多元素。
			else{
				//返回结果
				return null ;
			}
		}
		//当pointer走都最后一个节点的时候，就是pointer.next=null时候，head就是倒数第K个节点。
		while(pointer.next != null ){
			head = head.next;
			pointer = pointer.next;
		}
		
		return head ;
	}
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        System.out.println(findKthToTail(head, 1).value); // 倒数第一个
        System.out.println(findKthToTail(head, 5).value); // 中间的一个
//        System.out.println(findKthToTail(head, 9).value); // 倒数最后一个就是顺数第一个

//        System.out.println(findKthToTail(head, 10));
    }
	public static class ListNode {
		int value;
		ListNode next;
	}
}
