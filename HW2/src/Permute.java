import java.util.ArrayList;
import java.util.Scanner;


public class Permute {

	public static ArrayList<String> permute(int length){
		if(length == 1){
			ArrayList<String> temp = new ArrayList<String>();
			for(int i = 0; i <= 2; i++) temp.add(i+"");
			return temp;
		}
		
		ArrayList<String> strings = permute(length - 1);
		ArrayList<String> temp = new ArrayList<String>();
		for(String s : strings){
			for(int i = 0; i <= 2; i++){
				temp.add(s + i);
			}
		}
		return temp;
	}
	
	public static ArrayList<String> createErrorDetectingSet (ArrayList<String> strings){
		ArrayList<String> result = new ArrayList<String>();
		result.addAll(strings);
		for(int i = 0; i < result.size(); i++){
			String first = result.get(i);
			for(int j = i+1; j < result.size(); j++){
				String second = result.get(j);
				int count = 0;
				for(int k = 0; k < first.length(); k++){
					if(first.charAt(k) != second.charAt(k))
						count++;
				}
				if(count <= 1){
					result.remove(second);
					j--;
				}
			}
		}
		return result;
	}
	
	public static ArrayList<String> getNonEDset(ArrayList<String> permute, ArrayList<String> EDset){
		ArrayList<String> temp = new ArrayList<String>();
		temp.addAll(permute);
		temp.removeAll(EDset);
		return temp;
	}
	
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> strings = permute(scanner.nextInt());
		System.out.println("Permute: " + strings);
		ArrayList<String> EDset = createErrorDetectingSet(strings);
		System.out.println("EDset: " + EDset);
		ArrayList<String> nonEDset = getNonEDset(strings, EDset);
		System.out.println("Non-EDset: " + nonEDset);
		
	}
}
