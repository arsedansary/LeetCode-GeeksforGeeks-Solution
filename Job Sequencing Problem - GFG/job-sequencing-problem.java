//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution {

    // Define a custom Pair class to store the deadline and profit of a job.
    private static class Pair {
        int deadline;
        int profit;

        public Pair(Job job) {
            this.deadline = job.deadline;
            this.profit = job.profit;
        }
    }

    //Function to find the maximum profit and the number of jobs done.
    public int[] JobScheduling(Job arr[], int n) {

        //Create a list of pairs.
        List<Pair> v = new ArrayList<>();
        for(int i = 0; i < n; i++){
            v.add(new Pair(arr[i]));
        }

        //Sort the list in ascending order based on the deadline.
        Collections.sort(v, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.deadline, p2.deadline);
            }
        });

        //Create a min heap to store the profits in ascending order.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Variable to store the total number of jobs done.
        int total = 0;

        //Iterate over the list to find the maximum profit and the number of jobs done.
        for(int i = 0; i < n; i++){
            //If the current job can be done before its deadline, increment total and add its profit to the min heap.
            if(total < v.get(i).deadline){
                total++;
                pq.add(v.get(i).profit);
            }
            //If the current job cannot be done before its deadline, check if its profit is greater than the minimum profit in the min heap.
            //If it is, remove the minimum profit from the min heap and add the current job's profit to it.
            else{
                if(!pq.isEmpty() && pq.peek() < v.get(i).profit){
                    pq.poll();
                    pq.add(v.get(i).profit);
                }
            }
        }

        //Variable to store the maximum profit.
        int sum = 0;

        //Iterate over the min heap to find the maximum profit.
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        //Return the total number of jobs done and the maximum profit as an integer array.
        return new int[]{total, sum};
    }
}