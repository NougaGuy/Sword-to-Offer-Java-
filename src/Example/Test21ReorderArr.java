package Example;
/**
 * @author Nouga(Admin:85268)
 *Declaration : All Rights Reserved ! 
 *Date : 7/26
 */
public class Test21ReorderArr {

	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中的数字的顺序。
	 * 要求所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
	 */
	/**
	 * 该方法的套路是，维护两个指针，一个在最前面，一个在最后面。end每次移动一位，如果该坐标上是奇数，择停止移动。
	 * 直到start上的坐标是偶数，则交换。
	 * @param arr	输入的数组
	 */
	public static void reorder(int[] arr){
		//对于输入的数组为空，或者长度小于2的直接返回
		if(arr == null || arr.length < 2) {
			return ;
		}
		
		//两个指针 一个最开始 一个末尾
		int start = 0 ;
		int end = arr.length -1 ;
		
		while(start < end) {
			//找偶数
			while(start < end && arr[start] % 2 != 0){
				start ++;
			}
			//找奇数
			while(start < end && arr[end] % 2 == 0 ){
				end --;
			}
			//在start上是偶数，end上是奇数的时候。交换位置
			
			int tmp = arr[start] ;
			arr[start] = arr[end] ;
			arr[end] = tmp ;
		}
	}
	/**
	 * 该问题的衍生：如果HR要你继续回答，如果把条件改成：能被3整除的数在前；正负数中，负数在前。
	 * 无非就是让你写出可重用性高的代码，对于代码的可重用性是考察的观点，鉴于剑指Offer中提到的。
	 * 思路：抽取逻辑框架，把条件设置成两个函数（C++）根据条件就可以设计出不同的答案。
	 * Offer必备，一键秒杀。
	 */
	/**
	 * 输出数组的信息
	 * @param arr	待输出的数组
	 */
	public static void printArray (int[] arr){
		if(arr != null && arr.length > 0 ){
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorder(array);
        printArray(array);
    }
}
