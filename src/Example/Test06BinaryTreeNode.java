package Example;
/**
 * @author NougaGuy
 *Date:17/7/5
 *Declaration : All Rights Reserved !!
 *
 *Review：SingletonModel、SapceReplaceArray
 *Book P65 How do you find next node in BinaryTree
 */
public class Test06BinaryTreeNode {
	/**
	 *二叉树结点
	 *		root
	 *		/  \
	 *	  left right
	 */
	public static class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	/**
	 * 
	 * @param preorder 前序遍历
	 * @param inorder  中序遍历
	 * @return	root
	 */
	public static BinaryTreeNode construct(int[] preorder,int [] inorder){
		//健壮性
		if(preorder == null || inorder == null || preorder.length != inorder.length || inorder.length<1){
			return null;
		}
		//设置参数
		return construct(preorder, 0 , preorder.length-1,inorder,0,inorder.length-1);
	}
	
	public static BinaryTreeNode construct(int[] preorder,int ps,int pe,int[] inorder,int is ,int ie){
		//There is no variable to doing  
		if(ps>pe){
			return null;
		}
		//前序 root
		int value = preorder[ps];
		//中序 左1
		int index = is;
		/**
		 * index = 0(上面设置的)
		 * ie = inorder的长度
		 * 这一步执行完，中序遍历就到了root了
		 */
		while(index <= ie && inorder[index] != value){
			index ++;
		}
		//There is no variable to doing 
		if(index > ie){
			throw new RuntimeException("Invalid Input");
		}
		
		BinaryTreeNode node = new BinaryTreeNode();
		node.value = value;
		//Offer book p63 有图可以复习.
		/**
		 * 递归构建当前根节点的左子树，左子树的元素个数：index-is+1个
		 * 左子树对应的前序遍历的位置在[ps+1,ps+index-is]
		 * 左子数对应的中序遍历的位置在[is,index-1]
		 * index 被调用后会以ps+1为root重新定位
		 * 实现递归
		 */
		node.left = construct(preorder, ps+1,ps+index-is,inorder,is,index-1);
		/**
		 * 递归构建当前根节点的右子树，右子树的元素个数：ie-index个
		 * 右子数对应的前序遍历的位置在[ps+index-is+1,pe]
		 * 右子数对应的中序遍历的位置在[index+1,ie]
		 */
		node.right = construct(preorder,ps+index-is+1,pe,inorder,index+1,ie);
		//返回创建的根节点.
		return node;
	}
	
	public static void printTree(BinaryTreeNode root){
		if(root != null){
			printTree(root.left);
			System.out.print(root.value+" ");
			printTree(root.right);
		}
	}
	/**			普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
	 */
	private static void test1(){
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		BinaryTreeNode root = construct(preorder,inorder);
		printTree(root);
	}
	/**
	 * 所有节点没有右节点
	 * 					1
	 * 				   /
	 * 				  2
	 * 				 /
	 * 				3
	 * 			   /
	 * 			  4
	 * 			 5
	 */
	private static void test2(){
		int[] preorder = {1,2,3,4,5};
		int[] inorder = {5,4,3,2,1};
 		BinaryTreeNode root = construct(preorder,inorder);
		printTree(root);
	}
	/**
	 * 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
	 */
	private static void test3(){
		int[] preorder = {1,2,3,4,5};
		int[] inorder = {1,2,3,4,5};
		BinaryTreeNode root = construct(preorder,inorder);
		printTree(root);
	}
	//只有一个节点
	private static void test4(){
		int[] preorder = {1};
		int[] inorder = {1};
		BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
	}
	// 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }
    // 输入空指针
    private static void test6() {
        construct(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }
	public static void main(String[] args) {
		test1();
		System.out.println();
		test2();
		System.out.println();
		test3();
		System.out.println();
		test4();
		System.out.println();
		test5();
		System.out.println();
	/*	test6();					//Valid Input
		System.out.println();*/
	/*	test7();					//Valid Input
		System.out.println();*/
	}
}
