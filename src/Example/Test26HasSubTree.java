package Example;

/**
 * @author Nouga Date : 2017/8/9 Declaration : All Rights Reserved !
 */
public class Test26HasSubTree {
	/**
	 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。二叉树节点定义如下：
	 * 
	 * @author Nouga
	 */
	public static class BinaryTreeNode {
		double value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}

	/**
	 * 解体思路： 1.遍历A树，寻找是否有匹配B树根节点的节点。 2.匹配到则继续匹配接下来的值。（递归） 注 ：
	 * 声明树的时候用的是Double类型，Double和Float在做位运算的时候存在差异。所以设置条件最好用一个误差值来确定。
	 */
	/**
	 * @param root1
	 *            树A的根节点
	 * @param root2
	 *            树B的根节点
	 * @return
	 */
	public static Boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
		// 边界性和鲁棒性
		if (root1 == root2) {
			return true;
		}
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		
		//用一个Boolean来表示是否为子节点。
		boolean result = false;
		//如果两个根节点相同，则调用Match方法继续向下比。返回true就是子节点，反之false。
		if (root1.value == root2.value) {
			result = match(root1, root2);
		}
		if (result) {
			return true;
		}
		//若是没有匹配成功根节点，递归继续向下找。
		return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
	}

	/**
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	private static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
		//边界性检测、鲁棒性检查。
		if (root1 == root2) {
			return true;
		}
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		//递归继续向下匹配。
		if (root1.value == root2.value) {
			return match(root1.left, root2.left) && match(root1.right, root2.right);

		}
		//没匹配成功
		return false;
	}

	public static void main(String[] args) {
	        BinaryTreeNode root1 = new BinaryTreeNode();
	        root1.value = 8;
	        root1.right = new BinaryTreeNode();
	        root1.right.value = 7;
	        root1.left = new BinaryTreeNode();
	        root1.left.value = 8;
	        root1.left.left = new BinaryTreeNode();
	        root1.left.left.value = 9;
	        root1.left.right = new BinaryTreeNode();
	        root1.left.right.value = 2;
	        root1.left.right.left = new BinaryTreeNode();
	        root1.left.right.left.left = new BinaryTreeNode();
	        root1.left.right.left.left.value = 4;
	        root1.left.right.left.right = new BinaryTreeNode();
	        root1.left.right.left.right.value = 7;

	        BinaryTreeNode root2 = new BinaryTreeNode();
	        root2.value = 8;
	        root2.left = new BinaryTreeNode();
	        root2.left.value = 9;
	        root2.right = new BinaryTreeNode();
	        root2.right.value = 2;

	        System.out.println(hasSubTree(root1, root2));
	        System.out.println(hasSubTree(root2, root1));
	        System.out.println(hasSubTree(root1, root1.left));
	        System.out.println(hasSubTree(root1, null));
	        System.out.println(hasSubTree(null, root2));
	        System.out.println(hasSubTree(null, null));
	}
}
