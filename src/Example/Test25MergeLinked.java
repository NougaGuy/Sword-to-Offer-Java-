package Example;
/**
 * @author Nouga
 *Date : 2017/8/4
 *Declaration : All Rights Reserved ! 
 */
public class Test25MergeLinked {

	/**
	 * 面试题25：合并两个排序的链表
	 * 输入两个递增排序的链表，合并后，新的链表也是排序的。
	 * 例如：
	 * Chain 1 ： 1--3--5
	 * Chain 2 ： 2--4--6
	 * Merged Chain 3 ： 1--2--3--4--5--6
	 * @author Nouga
	 */
	public static class ListNode {
		int value ;
		ListNode next;
	}
	
	/**
	 * @param node1 排序好的链表1
	 * @param node2 排序好的链表2
	 * @return 返回被排好序的链表3
	 */
	public static ListNode merge(ListNode node1 , ListNode node2){
		//鲁棒性
		if(node1 == null){
			return node2;
		}
		if(node2 == null){
			return node1;
		}
		//一个返回的节点（Return）和一个指针
		ListNode node3 = new ListNode();
		ListNode pointer = node3;
		//当两个链表都不为空的时候，进行排序添加.
		while(node1 != null && node2 != null){
			if(node1.value < node2.value){
				/*node3.value = node1.value;
				node1=node1.next;*/
				pointer.value = node1.value;
				node1 = node1.next;
			}else{
				/*pointer.value = node2.value;
				node2 = node2.next;*/
				node3.value = node2.value;
				node2=node2.next;
			}
			//这样错了，每次头指针都会消失一个。
//			node3 = node3.next;
			node3.value = pointer.value;
			pointer = node3.next;
		}
		if(node1 != null){
			/*node3.value = node1.value;
			node3 = node3.next;
			node1 = node1.next;*/
			node3.next = node1;
		}
		if(node2 != null){
			/*node3.value = node2.value;
			node3 = node3.next;
			node2 = node2.next;*/
			node3.next = node2;
		}
			
		return node3.next;
	}
	
	
	public static void println(ListNode node3){
		while(node3 != null){
			System.out.print(node3.value);
			System.out.print("-->");
			node3 = node3.next;
		}
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


        ListNode head2 = new ListNode();
        head2.value = 1;

        head2.next = new ListNode();
        head2.next.value = 3;

        head2.next.next = new ListNode();
        head2.next.next.value = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;
        ListNode merge = merge(head, head2);
//        head = merge2(head, head2);
        println(merge);
    }
}
