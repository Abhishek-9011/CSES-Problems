import java.util.*;
import java.io.*;

public class FerrisWheel {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        long[] arr = sc.readlongarray(n);
        
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        long ans = 0;

        while (i <= j) {
            if (arr[i] + arr[j] <= x) {
                i++; 
            }
            j--;
            ans++; 
        }

        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] readlongarray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }
            return res;
        }
    }
}
