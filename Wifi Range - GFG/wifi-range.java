//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
public class Solution {
    public boolean wifiRange(int N, String S, int X) {
        int range = 0;
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == '1') {
                range = X; // room has range of X units
            } else {
                --range; // range decreases while we are going away from the room
            }
            
            // suppose 1 0 0 0 0 1 and X is 2, then range will become 2 1 0 -1 -2 respectively
            // range must not cross -X. Because -2 denotes that last two rooms (not with wifis) are not covering 
            // by room 1 but can be covered by last room bcuz it's range covers them in left
            if (range < -X) {
                return false;
            }
        }
        
        // range shouldn't be negative suppose 1001000 and X is 2 then range wil be
        // 2 1 0 2 1 0 -1 but there is no room at the last to cover the last 0 (room with no wifi)
        // this last room can be covered if there is a room with wifi at the last
        if (range < 0) {
            return false;
        }
        
        return true;
    }
}
