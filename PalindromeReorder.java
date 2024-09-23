import java.util.*;

import javax.print.DocFlavor.INPUT_STREAM;

import java.io.*;

public class PalindromeReorder {
    static FastReader sc = new FastReader();
    static final Random random = new Random();
    static long mod = 1000000007L;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String args[]) throws IOException {

        StringBuilder res = new StringBuilder();
        String s = sc.next();
        TreeMap<Character, Integer> mpp = new TreeMap<>();
        for (char c : s.toCharArray()) {
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        int oddValue = 0;
        char value = ' ';
        for (int i : mpp.values()) {
            if (i % 2 != 0) {
                oddCount++;
                oddValue = i;
            }
        }
        if (oddCount > 1) {
            res.append("NO SOLUTION");
        } else {
            char arr[] = new char[s.length()];
            int k = 0;
            int j = s.length()-1;
            for (int i = 0; i < s.length(); i++) {
                while (mpp.get(s.charAt(i)) % 2 == 0 && mpp.get(s.charAt(i)) != 0) {
                    arr[k] = s.charAt(i);
                    arr[j] = s.charAt(i);
                    k++;
                    j--;
                    mpp.put(s.charAt(i), mpp.get(s.charAt(i)) - 2);
                }
                if (mpp.get(s.charAt(i)) % 2 != 0) {
                    value = s.charAt(i);
                }
            }
            if (oddValue != 0) {
                for (int i = k; i <=j; i++) {
                    arr[i] = value;
                }
                for (int i = 0; i < arr.length; i++) {
                    res.append(arr[i]);
                }
            } else{
                for (int i = 0; i < arr.length; i++) {
                    res.append(arr[i]);
                }
            }
            res.append("\n");

        }
        print(res);

    }

    static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }

    static void ruffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static <E> void print(E res) {
        System.out.println(res);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static int abs(int a) {
        if (a < 0)
            return -1 * a;
        return a;
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readintarray(int n) {
            int res[] = new int[n];
            for (int i = 0; i < n; i++)
                res[i] = nextInt();
            return res;
        }

        long[] readlongarray(int n) {
            long res[] = new long[n];
            for (int i = 0; i < n; i++)
                res[i] = nextLong();
            return res;
        }
    }

}