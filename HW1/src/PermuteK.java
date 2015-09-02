import java.util.ArrayList;


public class PermuteK {
	
	public static ArrayList<String> permuteK(String string, int length ){
		ArrayList<String> switchedStrings = switchFirstLetter(string, 0);
		return permuteStrings(switchedStrings, length, 0);
	}
	
	public static ArrayList<String> permuteStrings (ArrayList<String> switchedStrings, int length, int index){
		
		if(index >= switchedStrings.size()){
			return null;
		}
		
		System.out.println("switchedStrings@permuteStrings : " + switchedStrings.get(index));
		ArrayList<String> strings = permuteStrings (switchedStrings, length , index + 1);
		
		if(strings == null){
			strings = new ArrayList<String>();
		}
		ArrayList<String> temp = permute(switchedStrings.get(index),length);
		System.out.println("permute@permuteStrings : " + switchedStrings.get(index));
		strings.addAll(temp);
		
		return strings;
		
		
	}
	
	public static ArrayList<String> permute(String string, int length){
		ArrayList<String> strings = new ArrayList<String>();
		
		if(length == 1 ){
			for(int i = 0; i < string.length(); i++){
				strings.add(string.charAt(i)+"");
			}
			return strings;
		}
		
		
		strings = permute(string.substring(1), length-1);
		
		ArrayList<String> permuted = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		for(String s : strings){
			temp.addAll(switchFirstLetter(s, 0));
		}
		for(String s : temp){
			permuted.add(string.charAt(0)+s);
			System.out.println("string@permute : " + string.charAt(0)+s);
		}
		
		strings = permuted;
		return strings;
	}
	
	public static ArrayList<String> switchFirstLetter(String string, int switchIndex){
	
		if(string.length() == switchIndex){
			return null;
		}
		ArrayList<String> strings = switchFirstLetter(string, switchIndex+1);
		
		if(strings == null){
			strings = new ArrayList<String>();
		}
		strings.add(string.charAt(switchIndex)+string.substring(0, switchIndex)+string.substring(switchIndex + 1 , string.length()));
		System.out.println("swtichedString@swtichFirstLetter : " + strings.get(strings.size()-1));
		return strings;
		
	};
	
	
	
	public static void main(String[]args){
		ArrayList<String> list = permute("abcdef", 3);
		list.sort(String.CASE_INSENSITIVE_ORDER);
		for(String str : list){
			System.out.println(str);
		}
		System.out.println(list.size());
	}
}
