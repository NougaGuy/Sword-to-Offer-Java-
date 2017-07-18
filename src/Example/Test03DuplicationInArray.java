package Example;

import java.util.HashMap;
import java.util.Map;


/**
 * How do you find duplication in array? 
 * @author NougaGuy
 * Review : 7/18
 */
public class Test03DuplicationInArray {
	
	public boolean duplicate(int[] arr){
		//鲁棒
		if(arr == null || arr.length<=0) throw new RuntimeException("Invalid Input");
		
		//边界性测试
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > arr.length-1) {
				 return false;
			}
		}
		
		/**
		 * 原理：把 每个数 都和 其他数 比较
		 * 先arr[0]上的数，进入while循环，不符合循环条件，不会出来。如果出来说明已经算是排好序了，利用该数相对应对应的坐标，还可以跟该坐标上的数进行比较。保证不遗漏
		 * 照该方法实现完，如果没有重复的，应该都是按顺序拍好的。
		 * 如果有，则利用该重复数相对应坐标上的数，可以对比出。
		 * 时间效率低，并不推荐。
		 */
		for (int i = 0; i < arr.length; i++) {
			while(arr[i] != i){
				if (arr[i] == arr[arr[i]]) {
					System.out.println(arr[i]);
					return true;
				}
				else{
					int temp = arr[i];
					arr[i] = arr[temp];
					arr[temp] = temp ;
				}
			}
		}
		//Time Complexity O(n^2)  Space Complexity O(1)
		return false;
	}
	
	//Double Cycle
	public int duplicate2(int[] arr){
		if(arr == null || arr.length<=0) throw new RuntimeException("Invalid Input");
		
		int result = -1;
		
		for (int i = 0; i < arr.length; i++) {
			//i跟里面循环比较，之后出来换i+1
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return arr[i];
				}
			}
		}
		
		//Time Complexity O(N^2) Space Complexity O(1)
		return result;
	}
	
	//Use Assistant Space 
	public int duplicate3(int [] arr){
		int result = -1;
		
		if(arr == null || arr.length<=0) throw new RuntimeException("Invalid Input"); 
		
//		Map<Integer , Integer> map = new HashMap<>();
		int[] entrys = new int[arr.length];
		
		/**
		 * 新创建一个数组，声明同样长度。
		 * 把坐标声明成arr[0]当中的值，并且内entrys[arr[i]]坐标上的值都是1。
		 * 如果有重复，则+=1 来标记，这样最后在返回大于1的坐标就是重复的。
		 * 时间效率高，推荐使用。
		 * 理解起来也好理解。
		 */
		for (int i = 0; i < arr.length; i++) {
			//把arr[i]的值当成entrys的key value当作次数，若value大于1 则表明有重复，返回。
			entrys[arr[i]] +=1;
			if (entrys[arr[i]]>1) {
				result = arr[i];
				break;
			}
		}
		return result ;
	}
	
	public static void main(String[] args) {
		int [] arr= {2,3,1,0,2,5,3};
		Test03DuplicationInArray test = new Test03DuplicationInArray();
		
		System.out.println(test.duplicate(arr));
//		System.out.println(test.duplicate2(arr));
//		System.out.println(test.duplicate3(arr));
	}
}
