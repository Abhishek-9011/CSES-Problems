import java.util.*;

class StringPermutation{
public static void swap(char arr[], int x, int y){
    char temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}
public static void helper(char arr[],HashSet<String> set, int idx){
    if(idx==arr.length){
        set.add(new String(arr));
        return;
    }
    for(int i=idx; i<arr.length; i++){
        swap(arr,i,idx);
        helper(arr,set,idx+1);
        swap(arr,i,idx);
    }
}
public static List<String> permutation(String s) {
    // Code here
    char arr[] = s.toCharArray();
    HashSet<String> set = new HashSet<>();
    helper(arr, set,0);
    ArrayList<String> ans = new ArrayList<>(set);
    Collections.sort(ans);
    return ans;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    List<String> ans = permutation(s);
    System.out.println(ans.size());
    for (int i = 0; i <ans.size(); i++) {
        System.out.println(ans.get(i));
    }
}
}