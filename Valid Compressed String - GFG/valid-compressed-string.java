//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   
    static int checkCompressed(String S, String T) {
        // code here
        int pos=0;
       
        int i=0;
        while(i<T.length()){
            if(Character.isDigit(T.charAt(i))){
                int num=0;
                while(i<T.length() && Character.isDigit(T.charAt(i)))
                {
                    num=num*10+T.charAt(i)-'0';
                    i++;
                }
                if(S.length()>=(pos+num)){
                    pos=pos+num;
                }else{
                    return 0;
                }
            }else{
                if(T.charAt(i)!=S.charAt(pos)){
                    
                    return 0;
                }
                pos++;
                i++;
            }   
        }
        return 1;
        
        
    }
}