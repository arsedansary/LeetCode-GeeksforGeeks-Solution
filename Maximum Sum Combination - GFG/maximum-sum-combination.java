//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class PairSum implements Comparable<PairSum>{
    int data,i,j;
    public PairSum(int data,int i,int j){
        this.data=data;
        this.i=i;
        this.j=j;
    }
    public int compareTo(PairSum p){
        return p.data-this.data;
    }
    
}
class Pair{
    int i,j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
     public boolean equals(Object o)
        {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair)o;
            return (i == obj.i && j == obj.j);
        }
 
         public int hashCode()
        {
            return Objects.hash(i, j);
        }
}
class Solution{  
    static List<Integer> maxCombinations(int n, int k, int a[], int b[]) {
        List<Integer>list=new ArrayList<>();
        PriorityQueue<PairSum>heap=new PriorityQueue<PairSum>();
        HashSet<Pair>map=new HashSet<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int i=n-1;
        int j=n-1;
   
        // A [ ] ={2, 3},
    //    B [ ] = {1, 4};
        map.add(new Pair(i, j));
        heap.add(new PairSum(a[i]+b[j], i, j));
        for(int l=0;l<k;l++){
            PairSum p=heap.poll();
            int im=p.i-1;
            int jm=p.j;
            list.add(p.data);
            if(im>=0&&jm>=0&map.contains(new Pair(im, jm))==false){
                map.add(new Pair(im, jm));
                heap.add(new PairSum(a[im]+b[jm], im, jm));
            }
            im=p.i;
            jm=p.j-1;
            if(im>=0&&jm>=0&map.contains(new Pair(im, jm))==false){
                map.add(new Pair(im, jm));
                 heap.add(new PairSum(a[im]+b[jm], im, jm));
            }
        }
    return list;}
}