//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int M[][] = new int[N][N];
            String arr[] = in.readLine().trim().split("\\s+");
            for(int i = 0;i < N*N; i++)
                M[i/N][i%N] = Integer.parseInt(arr[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.distinct(M, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int distinct(int M[][], int N)

    {

        // code here

        

        int row_0[] = new int[N];

        

        for (int i = 0; i < N; i++) {

            

            row_0[i] = M[0][i];

        }

        

        Arrays.sort(row_0);

        

        int result = 0;

        

        for (int j = 0; j < N; j++) {

            

            int x = Integer.MIN_VALUE;

            

            if (j == 0) {

                

                x = row_0[0];

            }

            

            else if (row_0[j] != row_0[j-1]) {

                

                x = row_0[j];

            }

            

            int count = 0;

            

            if (x != Integer.MIN_VALUE) {

                

                for (int row = 1; row < N; row++) {

                

                    for (int col = 0; col < N; col++) {

                    

                        if (M[row][col] == x) {

                            count++;

                            break;

                        }

                    }

                }

            }

            if (count == N - 1) {

                result++;

            }

        }

        return result;

    }

}