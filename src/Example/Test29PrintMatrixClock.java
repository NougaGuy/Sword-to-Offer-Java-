package Example;
/**
 * @author Nouga
 * Date : 2017/8/25
 * Declaration : All Rights Reserved !
 */
public class Test29PrintMatrixClock {

	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
	 * 我的思路：
	 * 如何表示一个矩阵？		          二维数组
	 * 如何指向矩阵中每一个值？		二维数组中用坐标来表示
	 * 如何循环打印？				前提是要符合一个矩阵的模型，需要判断。然后通过遍历打印。
	 * 如何向内打印？				每次打印需要判断是否有内值要打印，内值是一行，一列，或是矩阵。
	 * 处理边界值问题，若只有一行，一列等等？		程序入口就要鲁棒性检测。
	 */
	//入口
	public static void printMatrixCircle(int[][] arr){
		//
		if(arr == null){
			return ;
		}
		
		int start = 0 ;
		while(arr[0].length > start * 2 && arr.length > start * 2){
			printCircle(arr,start);
			start ++;
		}
	}

	private static void printCircle(int[][] arr,int start) {
		//列数
		int columns = arr[0].length;
		//行数
		int rows = arr.length;
		//当前列
		int endx = columns - 1 - start;
		//当前行
		int endy = rows -1 - start;
		//从左向右
		for (int i = start; i < endx; i++) {
			System.out.println(arr[start][i]);
		}
		//左边：从上到下
		if(start < endy){
			for (int i = start + 1; i < endy; i++) {
				System.out.println(arr[i][endx]);
			}
		}
		//下边：从右到左
		if(start < endx && start < endy){
			for (int j = endx + 1; j > start; j--) {
				System.out.println(arr[endy][j]);
			}
		}
		if(start < endy -1 ){
			for (int i = endy -1; i >start; i--) {
				System.out.println(arr[i][start]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		printMatrixCircle(arr);
	}
	
}
