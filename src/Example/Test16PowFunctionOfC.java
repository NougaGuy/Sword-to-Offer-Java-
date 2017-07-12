package Example;
/**
 * @author 85268
 *Date:17/7/11
 *Declaration: All Rights Reserved ! 
 */
public class Test16PowFunctionOfC {
	
	/**
	 * 实现函数double Power（double base， int exponent	） 求出bsae的exponent次方
	 * 不能使用函数库，不需要考虑大数问题。
	 * @param base	底
	 * @param exponent 指数
	 * @return 结果
	 */
	public static double power(double base,int exponent){
		//指数和底数不能同时为0
		if(base == 0 && exponent == 0 ){
			throw new RuntimeException("Invalid input.base and exponent both are zero");
		}
		
		//指数为0就返回1
		if(exponent == 0 ){
			return 1;
		}
		
		if(exponent >> 1 == 0){ //偶数
			int exponent_1 = exponent >> 1;
			double tmp = power(base,exponent_1);
			return tmp * tmp;
		} else{ //非偶数
			int exponent_2 = exponent - 1;  //-1后就是偶数
			double tmp = power(base,exponent_2);
			return tmp * base; //最后还有先开始减掉的一个base
		}
	}

	/**
	 * 边界，负面都没有考虑.
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double power1(float base, int exponent){
		double result = 1.0;
		for (int i = 1; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(power(2,4));
	}
}
