package Example;

import java.util.HashMap;
import java.util.Map;


/**
 * How do you find duplication in array? 
 * @author NougaGuy
 *
 */
public class DuplicationInArray {
	
	public boolean duplicate(int[] arr){
		
		if(arr == null || arr.length<=0) throw new RuntimeException("Invalid Input");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > arr.length-1) {
				 return false;
			}
		}
		
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
		//Time Complexity O(n)  Space Complexity O(1)
		return false;
	}
	
	//Double Cycle
	public int duplicate2(int[] arr){
		if(arr == null || arr.length<=0) throw new RuntimeException("Invalid Input");
		
		int result = -1;
		
		for (int i = 0; i < arr.length; i++) {
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
		DuplicationInArray test = new DuplicationInArray();
		
		System.out.println(test.duplicate(arr));
		System.out.println(test.duplicate2(arr));
		System.out.println(test.duplicate3(arr));
	}
}
