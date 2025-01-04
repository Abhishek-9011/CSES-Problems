import java.util.Scanner;

public class sumOfDigit {
        // public static  
    public static int findSum(int n){
        if(n==0){
            return 0;
        }
        int sum = 0;
        sum += n%10+findSum(n/10);
        return sum;
    }
    // public static int reverse(int arr[]){
        
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 123;
        System.out.println(findSum(n));
    }
}
