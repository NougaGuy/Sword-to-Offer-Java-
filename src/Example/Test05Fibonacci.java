package Example;
/**
 * @author 85268
 *Date:17/7/8
 *Declaration: All Rights Reserved!
 */
public class Test05Fibonacci {

	/**
	 * 写一个函数，输入N，求斐波那契（Fibonacci）数列的第N项
	 * 例如
	 * @param n	Fibonacci的数列
	 * @return	第N项结果
	 */
	public static long fibonacci(int n ) {
		//健壮性
		if(n<=0){
			return 0;
		}
		//输入1或者输入2的时候返回1
		if(n==1 ||n==2){
			return 1;
		}
		
		//记录前两个（n-2）的数值
		long prePre=1;
		//记住n-1的数值
		long pre =1;
		//当前数值
		long current =2;
		
		for (int i = 3; i < n; i++) {
			//这是第i个fibonacci值   等于前两个相加
			current = prePre + pre;
			//求完current 把指针向前移动，继续计算下个i的值.
			prePre = pre;
			pre = current;
		}
		
		return current;
		
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
	}
}
