package Example;

/**
 * @author Nouga Date : 2017/8/18 Declaration : All rights reserved !
 */
public class Test28isSymmetrical {

	/**
	 * 二叉树定义如下
	 */
	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		@Override
		public String toString() {
			return value + " ";
		}
	}

	public static boolean compare(BinaryTree tree) {
		// 我的思路：前序遍历（根，左，右） 对比 （根，右，左）
		// 网上思路：鲁棒性检测，判断节点值是否相同。
		if (tree == null)
			return true;

		return compareNode(tree.left, tree.right);
	}

	private static boolean compareNode(BinaryTree left, BinaryTree right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return left.value == right.value && 
				compareNode(left.left, right.right) && 
				compareNode(left.right, right.left);
	}

	// 前序遍历
	public static void preOrder(BinaryTree tree) {
		if (tree != null) {
			tree.toString();
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}

}
