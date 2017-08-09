package Example;

/**
 * @author Nouga
 *Date : 2017/8/9
 *Declaration : All Rights Reserved !
 */
public class Test26HasSubTree{
	/**
	 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。二叉树节点定义如下：
	 * @author Nouga
	 */
	public static class BinaryTreeNode{
		double m_dbValue;
		BinaryTreeNode m_pLeft;
		BinaryTreeNode m_pRight;
	}

	/**
	 * 解体思路：
	 *	1.遍历A树，寻找是否有匹配B树根节点的节点。
	 *	2.匹配到则继续匹配接下来的值。（递归）
	 *	注 ： 声明树的时候用的是Double类型，Double和Float在做位运算的时候存在差异。所以设置条件最好用一个误差值来确定。
	 */
	public static BinaryTreeNode hasSubTree(){
		
		return null;
	}
}
