//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    public int fun(int A, int B, int C, int D){

        int move=0;

        while(A>C){

            A = A/2;

            move++;

        }

        while(B > D){

            B = B/2;

            move++;

        }

        return move;

    }

    int carpetBox(int A, int B, int C, int D) { 

        long CarpetArea = A*B;

        long BoxArea = C*D;

        int moves = 0;

        // while(CarpetArea> BoxArea){

        //     if(A > B){

        //         A = A/2;

        //     }else B = B/2;

        //     moves++;

        //     CarpetArea = A*B;

            

        // }

        

        

        return  Math.min(fun(A,B,C,D), fun(B,A,C,D));

        // return moves;

    }

   

}

 

