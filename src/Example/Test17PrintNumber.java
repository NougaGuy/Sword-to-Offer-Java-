package Example;
/**
 * @author 85268
 *Date:17/7/13
 *Declaration: All Rights Reserved!!
 *Review: 
 */
public class Test17PrintNumber {
	
	public static void main(String[] args) {
		printOneToNthDigits(2);
	}
	
	/**
	 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
	 * @param n n 数字的最大位数
	 */
	public static void printOneToNthDigits(int n){
		//边界性、负面性
		if(n<1){
			throw new RuntimeException("Invalid Input");
		}
		
		int [] arr = new int[n];
		printOneToNthDigits(0,arr);
	}
	
	/**
	 * 
	 * @param n
	 * @param arr
	 */
	public static void printOneToNthDigits(int n,int[] arr){
		
		if(n>=arr.length){
			printArray(arr);
		}else{
			for(int i = 0 ;i<= 9 ;i++){
				arr[n] =i;
				printOneToNthDigits(n +1,arr);
			}
		}
	}
	
	public static void printArray(int[] arr){
		//找到第一个非0的元素
		int index = 0 ;
		while(index <arr.length && arr[index ]== 0){
			index ++;
		}
		//从第一个非0值开始输出到最后的元素
		for(int i =0 ; i < arr.length ; i++){
			System.out.println(arr[i]);
		}
		//条件成立说明数组中有非零元素，所以需要换行。
		if(index <arr.length){
			System.out.println();
		}
	}
}
