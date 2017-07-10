package Example;
/**
 * @author 85268
 *Date:17/7/9
 *Declaration: All Rights Reserved!
 */
public class Test14Cutting {

	/**
	 * 题目：一根长度n的绳子，把绳子剪成m段（都是整数）求最大值
	 * 动态规划：时间复杂度O(N^2) 空间复杂度O(N)
	 * @param length
	 * @return 最大乘机
	 */
	public static int maxAfterCutting(int length){
		//本方法由自下而上计算，避免了很多重复可能性计算。
		if(length<2){
			return 0;
		}
		if(length==2){
			return 2;
		}
		if(length==3){
			return 2;
		}
		
		int[] f = new int[length+1];
		f[0] = 0;
		f[1] = 1;
		f[2] = 2;
		f[3] = 3;
		int result = 0 ;
		for (int i = 4; i < length; i++) {
			int max = 0;
			for (int j = 1; j < i/2; j++) {
				int num = f[j] * f[i-j];
				if(max < num){
					max = num;
				}
				f[i] = max;
			}
		}
		result = f[length];
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(maxAfterCutting(8));
	}
}
