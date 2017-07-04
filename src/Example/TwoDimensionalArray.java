package Example;

/**
 * 
 * @author NougaGuy Date:2017/7/3 Declaration:All Rights Reserved !!
 */
public class TwoDimensionalArray {
	/**
	 * How do you find this number you just input in two-dimensional array
	 * 1 2 8 9 
	 * 2 4 9 12 
	 * 4 7 10 13 
	 * 6 8 11 15 
	 * All Rows and cols increased progressively
	 */
	public static boolean find(int[][] matrix, int number) {
		//If Array doesn't exist or The array is null . 
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			throw new RuntimeException("Invalid Input");

		int rows = matrix.length;	//Rows 
		int cols = matrix[1].length;//Cols
		
		int row = 0 ;
		int col = cols - 1;
		
		
		while(row >= 0 && row<rows && col >=0 && col< cols){
			if(matrix[row][col] == number ){
				return true;
			}else if (matrix[row][col] > number){
				//从右上角开始查，如果Number小于这个数，这一列都可以不用查了。之后列数向左推移。
				col --;
			}else {
				//如果Number比这个数大，往下查.
				row ++;
			}
			//除了从右上角开始查，还可以从左下角（如果Number大于这个数列向右推移） 等等。
			//空间复杂度O(1) 时间复杂度O(1)
		}
		return false;
	}
	
	public static void main(String[] args) {
		int [][] matrix = {
				{
					1,2,8,9
				},{
					2,4,9,12
				},{
					4,7,10,13
				},{
					6,8,11,15
				}
		};
		
		System.out.println(find(matrix,7));
		System.out.println(find(matrix,15));
		System.out.println(find(matrix,16));
		//健壮性测试
//		System.out.println(find(null,16));
	}
}
