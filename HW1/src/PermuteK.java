import java.util.ArrayList;
import java.util.Scanner;


public class PermuteK {
	
	
	public static ArrayList<String> permuteK(String string, int length){
		
		ArrayList<String> strings = new ArrayList<String>();
		strings.add(string);
		
		strings = permuteK(strings, length, 0);
		cutString(strings, length);
		
		return strings;
		
	}
	
	public static void cutString(ArrayList<String> strings, int length){
		for(int i = 0; i < strings.size(); i++){
			String temp = strings.get(i);
			temp = temp.substring(temp.length()-length);
			strings.set(i, temp);
		}
	}
	
	public static ArrayList<String> permuteK(ArrayList<String> strings, int length, int level){
		ArrayList<String> permuted;
		if( length <= 0 ){
			return strings;
		}
		permuted = permuteK(strings, length - 1, level + 1);
		
		ArrayList<String> temp = new ArrayList<String>();
		
		for(String s : permuted){
			temp.addAll(moveLetter(s, 0, level));
		}
		
		return temp;
		
	}
	
	public static ArrayList<String> moveLetter(String string, int index, int level){
		if(index >= string.length()-level){
			return null;
		}
		ArrayList<String> switched = moveLetter(string, index + 1, level);
		if(switched == null){
			switched = new ArrayList<String>();
		}
		
		String temp = "";
		
		for(int i = 0 ; i < string.length(); i++){
			if(i==index) continue;
			temp += string.charAt(i);
		}
		temp += string.charAt(index);
		switched.add(temp);
		return switched;
		
	}
	
	
	
	
	
	
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("String input : ");
		String input = scanner.nextLine();
		System.out.print("How many character do you want? : ");
		int num = Integer.parseInt(scanner.nextLine());
		ArrayList<String> permuted = permuteK(input, num);
		permuted.sort(String.CASE_INSENSITIVE_ORDER);
		for(String s : permuted){
			System.out.println(s);
		}
		System.out.println("Number of results : " + permuted.size());
		
	}
}
