import java.io.*;
import java.util.*;

public class Main {
    int count = 0;
    public static void func(String str,String asf)
    {
       if(str.length()==0)
       {
           System.out.println(asf);
           return;
       }
      func(str.substring(1),asf+str.charAt(0));
      func(str.substring(1),asf);
        
    }
	public static void main(String[] args) {
	    func("abc","");
    }
}


                        


                        


                        


                        


                        
                        
                        
                        