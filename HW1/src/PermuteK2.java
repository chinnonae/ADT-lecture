import java.util.ArrayList;


public class PermuteK2 {
	
	
	public static ArrayList<String> permuteK(String string, int length){
		
		ArrayList<String> strings = new ArrayList<String>();
		strings.add(string);
		
		strings = permuteK(strings, length, 0);
		cutString(strings, length, 0);
		
		return strings;
		
	}
	
	public static void cutString(ArrayList<String> strings, int length, int index){
		if(index == strings.size()) return;
		String string = strings.get(index);
		string = string.substring(string.length()-length);
		strings.set(index, string);
		cutString(strings, length, index+1);
		
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
		ArrayList<String> s = permuteK("abcdef", 3);
		s.sort(String.CASE_INSENSITIVE_ORDER);
		for(String a : s){
			System.out.println(a);
		}
		System.out.println(s.size());
		
	}
}
