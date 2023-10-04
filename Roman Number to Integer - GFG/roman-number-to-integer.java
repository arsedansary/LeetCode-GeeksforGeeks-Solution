//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
       int res = 0, nums = 0;
 for (int i = str.length()-1; i >= 0; i--) {
 switch(str.charAt(i)) {
 case 'I': nums = 1; break;
 case 'V': nums = 5; break;
 case 'X': nums = 10; break;
 case 'L': nums = 50; break;
 case 'C': nums = 100; break;
 case 'D': nums = 500; break;
 case 'M': nums = 1000; break;
 }
 if (4 * nums < res) res -= nums;
 else res += nums;
 }
 return res;
    }
}