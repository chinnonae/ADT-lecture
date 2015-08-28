/**
 *
 * @author paruj
 * 
 * Instruction: You must complete the code below and make them function correctly using recursion. No credits will be given otherwise.
 */

public class Rec {
    /** = number of times c occurs in s. */
    public static int numberc(char c, String s) {
    	
    	int count = 0;
    	if(s.length() != 1){
    		count = numberc(c,s.substring(1));
    	}
    	if(s.charAt(0)==c){
    		count++;
    	}
    	return count;

    }

    /** = number of chars in s that are not c. */
    public static int numberNotc(char c, String s) {
    	
    	int count = 0;
    	if(s.length() != 1){
        	count = numberNotc(c, s.substring(1));
    	}
    	if(s.charAt(0) != c){
    		count++;
    	}
    	return count;
	
    }

    /** = a copy of s but with all occurrences of c replaced by d.
		Example: replace("abeabe", 'e', '$') = "ab$ab$".
		For lab purposes, do NOT use the pre-existing String function replace */
    public static String replace(String s, char c, char d) {
	
    	char first = s.charAt(0);
    	if(s.length() == 1){
    		if(first == c){
    			return d+"";
    		} else {
    			return s;
    		}
    	}
    	
    	String newS = replace(s.substring(1), c, d);
    	if(s.charAt(0) == c){
    		newS = d + newS;
    	} else {
    		newS = first + newS;
    	}
    	
    	return newS;
    	
    	
    }

    /** = a copy of s with adjacent duplicates removed.
		Example: for s = "abbcccdeaaa", the answer is "abcdea".*/
    public static String rem1(String s) {
	
		if(s.length() == 1){
			return s;
		}
		
		char first = s.charAt(0);
		String newS = rem1(s.substring(1));
		if(newS.charAt(0) != first){
			newS = s.charAt(0) + newS;
		}
		
		return newS;
    }

    /** = number of the digits in the decimal representation of n.
		e.g. numDigits(0) = 1, numDigits(3) = 1, numDigits(34) = 2.
		numDigits(1356) = 4.
		Precondition: n >= 0. */
    public static int numDigits(int n) {
	
    	int divided10 = n/10;
    	if(divided10 == 0){
    		return 1;
    	}
    	
    	int result = numDigits(divided10) + 1;
    	return result;
    }

    /** = sum of the digits in the decimal representation of n.
      e.g. sumDigits(0) = 0, sumDigits(3) = 3, sumDigits(34) = 7,
      sumDigits(345) = 12.
      Precondition: n >= 0. */
    public static int sumDigits(int n) {
	
    	int divided10 = n/10;
    	int modded10 = n%10;
    	
    	if(divided10 == 0){
    		return n;
    	}
    	
    	int result = sumDigits(divided10)+modded10;
    	return result;
	
    }
	
    /** = a copy of s with to_remove_char removed.
		Example: removeChar("abeabe", 'e') = "abab". */
	public static String removeChar(String s, char to_remove_char) {
	
		char first = s.charAt(0);
		if(s.length() == 1){
			if(first == to_remove_char){
				return "";
			} else {
				return s;
			}
		}
		
		String newS = removeChar(s.substring(1) , to_remove_char);
		if(first == to_remove_char){
			return newS;
		} else {
			return first + newS;
		}
	
	}
	
    /** = a copy of s with characters in reverse order.
		Example: reverse("abcdefg") = "gfedcab". */
	public static String reverse(String s) {
	
		if(s.length() == 1){
			return s;
		}
		
		String newS = reverse(s.substring(1));

		return newS + s.charAt(0);
	}

    public static void main(String[] args) {
        System.out.println(numberc('a', "aaabbbaccabda"));
        System.out.println(numberc('b', "aaabbbaccabda"));
        System.out.println(numberc('c', "aaabbbaccabda"));
        System.out.println(numberc('d', "aaabbbaccabda"));
        System.out.println("-----------------");
        System.out.println(numberNotc('a', "aaabbbaccabda"));
        System.out.println(numberNotc('b', "aaabbbaccabda"));
        System.out.println(numberNotc('c', "aaabbbaccabda"));
        System.out.println(numberNotc('d', "aaabbbaccabda"));
        System.out.println("-----------------");
        System.out.println(replace("aaabbbaccabda", 'a', 'b'));
        System.out.println(replace("aaabbbaccabda", 'b', 'c'));
        System.out.println(replace("aaabbbaccabda", 'c', 'd'));
        System.out.println(replace("aaabbbaccabda", 'd', 'a'));
        System.out.println("-----------------");
        System.out.println(rem1("aaabbbaccabda"));
        System.out.println(rem1("abbcccdeaaa"));
        System.out.println(rem1("aaaaaaaaaaaaaaaaaaa"));
        System.out.println(rem1("aabbbccccdddddeeeeeee"));
        System.out.println("-----------------");
        System.out.println(numDigits(123));
        System.out.println(numDigits(-123));
        System.out.println(numDigits(123456));
        System.out.println(numDigits(-123456));
        System.out.println(numDigits(1));
        System.out.println(numDigits(0));
        System.out.println("-----------------");
        System.out.println(sumDigits(123));
        System.out.println(sumDigits(-123));
        System.out.println(sumDigits(123456));
        System.out.println(sumDigits(-123456));
        System.out.println(sumDigits(1));
        System.out.println(sumDigits(0));
		System.out.println("-----------------");
		System.out.println(removeChar("eawabbcceccddeeaaeeeee", 'e'));
		System.out.println(removeChar("acacacacac", 'a'));
		System.out.println("-----------------");		
		System.out.println(reverse("aaabbbaccabda"));
        System.out.println(reverse("abbcccdeaaa"));
		System.out.println(reverse("AMANAPLANACANALPANAMA"));
    }
}