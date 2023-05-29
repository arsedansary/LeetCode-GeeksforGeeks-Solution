//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        Map<Integer, String> map = new HashMap<>();
         ArrayList<String> list = new ArrayList<>();
         for (int i = 0; i < Dictionary.length; i++) {
             String str = "";
             for (int j = 0; j < Dictionary[i].length(); j++) {
                 if (Dictionary[i].charAt(j) >= 65 && Dictionary[i].charAt(j) <= 90) {
                     str += Dictionary[i].charAt(j);
                 }
             }
             map.put(i, str);
              boolean b=false;
        for(int p=0;p<Pattern.length();p++)
        {

            if(str.length()>p&&Pattern.charAt(p)==str.charAt(p))
                b=true;
            else{
                b=false;
                break;
            }


        }
        if (b==true)
            list.add(Dictionary[i]);
         }
         if (list.isEmpty())
             list.add(String.valueOf(-1));
         Collections.sort(list);
         return list;
}
}