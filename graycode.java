import java.util.*;
public class  graycode{
    public static void helper(int n,int arr[], ArrayList<ArrayList<Integer>> ans,  ArrayList<Integer> temp,int i){
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j <arr.length; j++) {
            temp.add(arr[j]);
            helper(n, arr, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int arr[] = {0,1};
        helper(n,arr,ans,temp,0);
        for (int i = 0; i <ans.size(); i++) {
            for (int j = 0; j <ans.get(0).size(); j++) {
                System.out.print(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}
