import java.util.*;
public class BinSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter your target element which you want to search from the array");
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        int [] arr= {2,5,7,12,67,232,6575};
//        int target=12;
        int answer=binSearchRecursion(arr,0, arr.length, target);
        System.out.println(answer);
    }
    //Iterative solution
    static int binSearch(int [] arr, int target) {
        int start= 0;
        int end= arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    //recursion solution
    static int binSearchRecursion(int[] arr, int start, int end, int target) {
        int mid=(start+end)/2;
        if (arr[mid]==target) {
            return mid;
        }
        if (arr[mid]>target) {
            return binSearchRecursion(arr, start, mid-1, target);
        }
        return binSearchRecursion(arr, mid+1, end, target);
    }

}
