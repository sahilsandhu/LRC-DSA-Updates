import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }

  public static int getnum(String str, HashMap<Character, Integer> hm)
  {
      int res = 0;
      for(int i=0;i<str.length();i++)
      {
          char ch = str.charAt(i);
          res = res*10+hm.get(ch);
      }
      return res;
  }
  
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
	    // write your code here
	    if(idx == unique.length())
	    {
	        
	        int num1 = getnum(s1,charIntMap);
	        int num2 = getnum(s2,charIntMap);
	        int num3 = getnum(s3,charIntMap);
	        //System.out.println(num1+" "+ num2+" "+ num3);
	       // if((num1 + num2)== num3){
	            
	            
	       //     for(int i='a';i<='z';i++)
	       //     {
	       //         char ch = (char)i;
	       //         if(charIntMap.containsKey(ch))
	       //         System.out.print(ch+'-'+charIntMap.get(ch)+" ");
	       //     }
	       //     System.out.println();
	       // }
	       
	       if(num1 + num2 == num3){
				for(int i = 0; i < 26; i++){
					char ch = (char)('a' + i);
					if(charIntMap.containsKey(ch)){
						System.out.print(ch + "-" + charIntMap.get(ch) + " ");
					}
				}
				System.out.println();
			}
	        return;
	    }
	    
	    for(int i=0;i<=9;i++)
	    {
	        if(usedNumbers[i] == false)
	        {
	            usedNumbers[i] = true;
	            charIntMap.put(unique.charAt(idx), i);
	            solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
	            usedNumbers[i] = false;
	            charIntMap.put(unique.charAt(idx), -1);
	        } 
	    }
	    
  }

}
