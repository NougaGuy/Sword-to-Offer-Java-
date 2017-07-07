package Example;
/**
 * @author NougaGuy
 *Date:7/7
 *Declaration: All Rights Reserved!
 *review：DuplicationInArray
 */
public class Test08MinInArray {
	/**
	 * 一个旋转数组，求最小数
	 * 旋转数组：数组中最开始的几个数移动到末尾
	 * 例如｛3，4，5，1，2｝---｛1，2，3，4，5｝
	 * 适用二分查找
	 * @param array
	 * @return
	 */
	public static int min(int[] array){
		//健壮性
		if(array == null ||array.length ==0){throw new RuntimeException("Invalid Input");}
		//开始处理第一个位置
		int lo =0;
		//开始处理最后一个位置
		int hi =array.length-1;
		//设置初始值
		int mi =lo;
		
		while(array[lo] >= array[hi]){
			if(hi-lo==1){
				return array[hi];
			}
			//取中间的数字,每次调用的时候，都会算mi的值，不断的缩小范围.
			mi = lo +(hi-lo)/2;
			//三个数都相等的情况下，调用方法。
			if(array[mi] == array[lo] && array[hi] == array[mi]){
				return minInorder(array,lo,hi);
			}
			
			if (array[mi] >= array[lo]) {
				lo=mi;
			}

			else if(array[mi] <= array[hi]){
				hi=mi;
			}
		}
		return array[mi];
		//空间复杂度O(n)  时间复杂度O(logn)
	}
	
	/**
	 * 找出数组中最小的数字
	 * @param numbers []
	 * @param start	Begin
	 * @param end	End
	 * @return		Min
	 */
	public static int minInorder(int[] numbers , int start, int end){
		int result = numbers[start];
		for (int i = start; i <= end; i++) {
			if (result > numbers[i]) {
				result = numbers[i];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//Typical
		int[] array1 = {3,4,5,1,2};
		System.out.println(min(array1));
		//重复是最小的数字
		int[] array2 = {3,4,5,1,1,2};
		System.out.println(min(array2));
		//有重复数字
		int[] array3 = {3,4,5,1,2,2};
		System.out.println(min(array3));
		//有多个最小数。
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(min(array4));
        //单调升序数组,旋转0个元素
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(min(array5));
        //数组只有一个
        int[] array6 = {2};
        System.out.println(min(array6));
        //数组相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(min(array7));
        // 输入NULL
        System.out.println(min(null));
	}
}
