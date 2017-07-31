package Example;
/**
 * @author Nouga
 * Date: 2017/7/31
 * Declaration : All Rights Reserved ! 
 */
public abstract class Test23MeetingNode {

	/**
	 * 如果一个链表中包含环，如何找出环节点？（或者如何遍历环中的节点？）
	 * 这道题，鲁棒性非常的重要！存在很多潜在的隐患，如果只写出来，不测试边界、负面。那拿Offer也够呛。
	 */
	
	public static class ListNode {
		private int val ;
		private ListNode next ;
		public ListNode () {
		}
		
		public ListNode(int val) {
			this.val = val ;
		}
		
		@Override
		public String toString() {
			return val + "";
		}
	}
	
	public static ListNode mettingNode(ListNode head ){
		ListNode fast = head ;
		ListNode slow = head ;
		
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow ) {
				break ;
			}
		}
		
		//链表中没有环
		if(fast == null || fast.next == null ){
			return null ;
		}
		
		//fast重新指向第一个节点
		fast = head ;
		
		while(fast != slow ){
			fast = fast.next ;
			slow = slow.next ;
		}
		
		return fast ;
	}
	
	
}
