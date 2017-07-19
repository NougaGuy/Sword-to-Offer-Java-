package Example;

import java.util.Stack;

/**
 * 
 * @author Nouga
 *Date:2017/7/4
 */
public class Test05ListNodeTest {
	/**
	 * 结点对象
	 * @author 85268
	 *
	 */
	public static class ListNode{
		int val;
		ListNode nxt;
	}
	
	/**
	 * 输入个链表的头节点，从尾到头反过来打印每个节点的值
	 * 用栈的方式
	 * 
	 * 关于Stack extends Vector 小知识：
	 * Vector 和ArrayList 一个是线程安全的，一个是不安全的。
	 * Vector类中所有的方法使用了Synchronized修饰
	 * Stack是一个常用的实现类，俗话说叫后进先出队列（）
	 * 
	 * 时间复杂度 O(1) 空间复杂度O(1)
	 * @param root 链表头结点
	 */
	public static void printListInverselyUsingIteration(ListNode root){
		Stack<ListNode> stack = new Stack<>();
		//从头放入栈中
		while(root != null){
			stack.push(root);
			root = root.nxt;
		}
		//接收
		ListNode tmp;
		//从头取出来，实现反列
		while(!stack.isEmpty()){
			tmp = stack.pop();
			System.out.println(tmp.val+ " ");
		}
	}
	/**
	 * 输入个链表的头节点，从尾到头反过来打印每个节点的值
	 * 用栈的方式
	 * @param root
	 */
	public static void printListInverselyUsingRecursion(ListNode root){
		/**
		 * 堆与栈
		 * 栈上放了方法和局部变量
		 * 堆上放了实例变量外面是对象。
		 * 这方法不断调用自身，在栈上不断创建方法进程，原先的方法被压到下面去了。如此有O(root.nxt)的方法。
		 * 然后一个个的完成，从而实现反向输出。
		 */
		if(root != null){
			printListInverselyUsingRecursion(root.nxt);
			System.out.println(root.val +" ");
		}
	}
	public static void main(String[] args) {
		ListNode root = new ListNode();
		root.val = 1; 
		root.nxt = new ListNode();
		root.nxt.val = 2;
		root.nxt.nxt = new ListNode();
		root.nxt.nxt.val = 3;
		root.nxt.nxt.nxt = new ListNode();
		root.nxt.nxt.nxt.val = 4;
//		printListInverselyUsingIteration(root);
		System.out.println();
		printListInverselyUsingRecursion(root);
	}
}
