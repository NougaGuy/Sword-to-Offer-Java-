package Example;
/**
 * You need to replace space to "%20" in String array . 
 * Just like "We are happy" to "We%20are%20happy%20"
 * @author NougaGuy
 *Date:2017/7/3
 */
public class Test05SpaceReplaceInArray {
	/**
	 * 
	 * @param string  Need to replace array 
	 * @param usedLength	Original length
	 * @return	If the array doesn't any problems return array after replace 
	 */
	public static int replaceBlank(char[] string , int usedLength){
		//Count blank 
		int whiteCount = 0; 
		for (int i = 0; i < string.length; i++) {
			if(string[i] == ' '){
				whiteCount ++;
			}
		}
		//Decide to whether Input legal
		if(string == null || string.length<usedLength){
			return -1;
		}
		//After replace length
		int targetLength = whiteCount*2+usedLength;
		int tmp = targetLength ; //Keep ;used to return 
		
		
		//Bounds
		if(targetLength > string.length){
			return -1;
		}
		
		//No blank
		if(whiteCount == 0 ){
			return usedLength;
		}
		
		usedLength -- ;
		targetLength -- ;
		while(usedLength >= 0 && usedLength < targetLength){
			if(string[usedLength] == ' '){
				string[targetLength--] = '0';
				string[targetLength--] = '2';
				string[targetLength--] = '%';
			}else {
				string[targetLength--] = string[usedLength];
			}
			usedLength--;
		}
		//时间复杂度O(n) 空间复杂度O(1)
		return tmp;
	}
	
	/**
	 *有两个被排序好的数组，且数组1中有内容可以容下数组2的所有参数。
	 *把两个数组整合到一起，并排序。
	 * @param arr1 数组1
	 * @param arr2 数组2
	 * @return
	 */
	public static int[] compositor(int[] arr1,int arr,int length){
		//健壮性
		if(arr1 == null || arr1.length<1) throw new RuntimeException("Invalid Input");
		//两个指针
		int merge = length + arr;
		
		for (int i = arr1.length-1; i < arr1.length; i--) {
			if (arr1[i] < arr) {
				arr1[++i] = arr;
				break;
			}else{
				arr1[merge--] = arr1[length];
				length --;
			}
		}
		return arr1;
	}
	
	public static void main(String[] args) {
		char[] string = new char[50];
		string[0] = ' ' ;
		string[1] = 'e' ;
		string[2] = ' ' ;
		string[3] = ' ' ;
		string[4] = 'b' ;
		string[5] = ' ' ;
		string[6] = ' ' ;
		string[7] = 'c' ;
		
		int length = replaceBlank(string,12);
		System.out.println(new String(string,0,length));
		
		int arr1[] = {1,3,5,7,9};
		int[] is = compositor(arr1,2,5);
		for (int i = 0; i < is.length; i++) {
			System.out.println(arr1[i]);
		}
	}
}
