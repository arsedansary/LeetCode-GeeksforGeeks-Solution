//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends

class Solution {
    public List<String> find_permutation(String S) {
        char temp[]=S.toCharArray();
        Arrays.sort(temp);
        S=new String(temp);
        ArrayList<String> al=new ArrayList<>();
        String ans="";
        help(S,ans,al);
        return al;
        
    }
    static void help(String str,String ans,ArrayList<String> al){
        if(str.length()==0){
            if(!al.contains(ans))al.add(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);
            help(newstr,ans+curr,al);
        }
    }
}