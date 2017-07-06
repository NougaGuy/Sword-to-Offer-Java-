package Example;

import java.util.Stack;

/**
 * 
 * @author 85268
 *Date:17/7/6
 *Declaration: All Rights Reserved!!
 */
public class Test07Stack {
	/**
	 * 用两个栈模拟队列
	 * 声明如下：实现它的两个函数appendTail和deleteHead
	 * 分别完成在对象尾部插入结点和在队列头部删除结点的功能。
	 */
	public static class MList<T>{
		//插入栈，只用于插入数据
		private Stack<T> stack1 = new Stack<>();
		//弹出栈，只用于弹出数据
		private Stack<T> stack2 = new Stack<>();
		public MList(){
			
		}
		
		
		public void appendTail(T t){
			stack1.add(t);
		}
		public void deleteHead(T t){
			//先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，并且压入栈中。
			if(stack2.isEmpty()){
				while(!stack1.isEmpty()){
					stack2.add(stack1.pop());
				}
			}
			if(stack2.isEmpty()){
				throw new RuntimeException("No more element");
			}
			//返回弹出栈的栈顶元素，对应的就是队首元素。
			stack2.pop();
		}
	}
}
