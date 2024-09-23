import java.util.*;
import java.io.*;

public class TwoSets {
    static FastReader sc = new FastReader();
    static final Random random = new Random();
    static long mod = 1000000007L;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String args[]) throws IOException {
        int n = sc.nextInt();
        StringBuilder res = new StringBuilder();
        long sum = ((long) n * (n + 1)) / 2;

        if (sum % 2 == 0) {
            long reqSum = sum / 2;
            res.append("YES\n");

            ArrayList<Integer> set1 = new ArrayList<>();
            ArrayList<Integer> set2 = new ArrayList<>();

            for (int i = n; i >= 1; i--) {
                if ((reqSum - i) >= 0) {
                    set1.add(i);
                    reqSum -= i;
                } else {
                    set2.add(i);
                }
            }

            res.append(set1.size()+"\n");
            for (Integer integer : set1) {
                res.append(integer+" ");
            }

            res.append("\n"+set2.size()+"\n");
            for (Integer integer : set2) {
                res.append(integer).append(" ");
            }
        } else {
            res.append("NO\n");
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