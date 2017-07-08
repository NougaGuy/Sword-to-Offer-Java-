package Example;

/**
 * @author 85268 
 * Date:17/7/8 
 * Declaration: All Rights Reserved! 
 * Test Detail A B C D E
 * 			   F G H I J
 * 			   K L M N O 
 * 				例如：连接BGHM 用最优路径找出路线，不得连接重复的路径 鲁棒性和健壮性需要判断
 *         俗称：回溯大法！！！！！！！！
 */
public class Test12MatrixSearch {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean visitFlags[] = new boolean[matrix.length];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, rows, cols, row, col, str, 0, visitFlags))
					return true;
			}
		}
		return false;
	}

	boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int k, boolean[] visitFlags) {
		int index = row * cols + col;

		if (row < 0 || col < 0 || row >= rows || col >= cols || visitFlags[index] || matrix[index] != str[k]) {
			return false;
		}

		visitFlags[index] = true;

		if (k == str.length - 1) {
			return true;
		}

		k++;

		if (hasPathCore(matrix, rows, cols, row + 1, col, str, k, visitFlags)
				|| hasPathCore(matrix, rows, cols, row - 1, col, str, k, visitFlags)
				|| hasPathCore(matrix, rows, cols, row, col + 1, str, k, visitFlags)
				|| hasPathCore(matrix, rows, cols, row, col - 1, str, k, visitFlags)) {
			return true;
		}

		visitFlags[index] = false;
		return false;
	}

}
