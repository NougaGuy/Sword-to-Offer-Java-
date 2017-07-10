package Example;
/**
 * @author 85268
 *Date:17/7/10
 *Declaration: All Rights Reserved ! 
 */
public class Test15OneInBinary {

	/**
	 * 实现一个函数
	 * 输入一个整数，输入该整数的二进制表示中1的个数
	 * 例如 9 - 1001 有两位是1
	 * @param n 输入的数字
	 * @return 返回转换后二进制的1个位数
	 */
	public static int numberOfOne(int n){
		//记录数字中1的位数
		int result = 0 ;
		/**
		 * JAVA语言规范中，int整形占四个字节，总计32位
		 * 对每一个位置与1进行求与操作，再累加就可以求出当前数字表示的多少位１
		 */
		for(int i = 0 ; i < 32 ; i++){
			//与运算
			result += (n & 1);
			//左移动
			n >>>= 1;
		}
		
		return result ;
	}
	
	/**
	 * 这个方法效率更高
	 * @param n
	 * @return
	 */
	public static int numberOfOne2(int n){
		int result = 0 ;
		while(n != 0){
			result ++;
			//从最右边的１开始，每一次操作都使得ｎ最右的一个１变成０，即使符号位也会进行操作。
			n = (n - 1) & n;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(numberOfOne(0B00000000_00000000_00000000_00000001)); // 1
		System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000001)); // 1
		System.out.println(numberOfOne2(0B11111111_11111111_11111111_11111111)); // -1
	}
}
