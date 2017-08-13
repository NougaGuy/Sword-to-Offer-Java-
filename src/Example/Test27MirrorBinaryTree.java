package Example;
/**
 * @author 85268
 *Date : 2017/8/13
 *Declaration : All Rights Reserved !
 */
public class Test27MirrorBinaryTree {

	/**
	 * 二叉树定义如下
	 */
	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;
	}
	
	/**
	 * 输入一个二叉树，该函数输出它的镜像。
	 * @param pervious
	 * @return 镜像后的二叉树.
	 */
	public static void mirrorMethod(BinaryTree pervious){
		/**
		 * 步骤如下：1.通过前序遍历二叉树所有节点
		 * 		  2.然后通过递归，交换带有子节点的节点。
		 */
		BinaryTree temp = null ;   //临时
		if(pervious == null || pervious.left == null && pervious.right == null) return ;
		//交换节点左右两个子树.
		temp = pervious.left;
		pervious.left = pervious.right;
		pervious.right = temp ;
		if(pervious.left != null){
			mirrorMethod(pervious.left);
		}
		if(pervious.right!=null){
			mirrorMethod(pervious.right);
		}
	}
	
	public static void print(BinaryTree print){
		System.out.print(print.value);
		if(print.left!=null){
			print(print.left);
		}
		if(print.right!=null){
			print(print.right);
		}
	}
	public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        BinaryTree root = new BinaryTree();
        root.value = 8;
        root.left = new BinaryTree();
        root.left.value = 6;
        root.left.left = new BinaryTree();
        root.left.left.value = 5;
        root.left.right = new BinaryTree();
        root.left.right.value = 7;
        root.right = new BinaryTree();
        root.right.value = 10;
        root.right.left = new BinaryTree();
        root.right.left.value = 9;
        root.right.right = new BinaryTree();
        root.right.right.value = 11;
        print(root);
        System.out.println();
        mirrorMethod(root);
        print(root);
        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        BinaryTree root2 = new BinaryTree();
        root2.value = 1;
        root2.left = new BinaryTree();
        root2.left.value = 3;
        root2.left.left = new BinaryTree();
        root2.left.left.value = 5;
        root2.left.left.left = new BinaryTree();
        root2.left.left.left.value = 7;
        root2.left.left.left.left = new BinaryTree();
        root2.left.left.left.left.value = 9;
        System.out.println("\n");
        print(root2);
        System.out.println();
        mirrorMethod(root2);
        print(root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        BinaryTree root3 = new BinaryTree();
        root3.value = 0;
        root3.right = new BinaryTree();
        root3.right.value = 2;
        root3.right.right = new BinaryTree();
        root3.right.right.value = 4;
        root3.right.right.right = new BinaryTree();
        root3.right.right.right.value = 6;
        root3.right.right.right.right = new BinaryTree();
        root3.right.right.right.right.value = 8;
        System.out.println("\n");
        print(root3);
        System.out.println();
        mirrorMethod(root3);
        print(root3);


    }
}
