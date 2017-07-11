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
	 * @param base	指次
	 * @param exponent	幂
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
		
		//指数的绝对值
		long exp = exponent;
		if(exponent < 0 ){
			exp = - exp;
		}
		//求幂次方
		double result = powerWithUnsignedExponent(base,exponent);
		//指数是负数，要进行求倒数
		if(exponent < 0){
			result = 1/result;
		}
		return result;
	}
	
	/**
	 * 求一个数的正整数次幂，不考虑溢出
	 * @param base
	 * @param exponent
	 * @return 结果
	 */
	public static double powerWithUnsignedExponent(double base, int exponent){
		//如果指数为0，返回1
		if(exponent == 0){
			return 1;
		}
		//指数为1，返回底数。
		if(exponent == 1){
			return base;
		}
		//递归一半的值
		double result = powerWithUnsignedExponent(base,exponent>>2);
		
		//求最终的值，如果是奇数就还要乘一次底数
		result *= result;
		
		if(exponent % 2 != 0 ){
			result *= base;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(power(2,4));
	}
}
