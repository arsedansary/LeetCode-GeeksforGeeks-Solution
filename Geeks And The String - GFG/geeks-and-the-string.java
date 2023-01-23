//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
  public static String removePair(String str) {

        Stack<Character> st = new Stack<>();

        StringBuilder sb = new StringBuilder();        

        for(int i=0; i<str.length(); i++) {

            if(st.isEmpty()) {

                st.push(str.charAt(i));

            }

            else if(str.charAt(i)==st.peek()) {

                st.pop();

            } else {

                st.push(str.charAt(i));

            }

        }

        

        while(!st.isEmpty()) {

             sb.append(st.pop());

        }

        return
        sb.length()==0 ? "-1" : sb.reverse().toString();


}
        
}