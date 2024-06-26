import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lab1 {
    private static InputReader in;
    private static PrintWriter out;

    public static long sumToN(long N) {
        /*
         * Untuk bilangan N yang sangat besar, komputasi N(N+1)/2 menghasilkan bilangan yang amat besar sehingga overflow.
         * Maka perlu kita lakukan pembagian dengan 2 terlebih dahulu dibanding perkalian N(N+1) terlebih dahulu.
         * Cek mana yang genap, N atau (N+1). Yang genap dibagi 2 terlebih dahulu.
         */
        if (N % 2 == 0) return (N / 2) * (N + 1);
        return ((N+1) / 2) * N;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        in = new InputReader(inputStream);
        OutputStream outputStream = System.out;
        out = new PrintWriter(outputStream);

        // Read value of T
        int T = in.nextInt();

        // Run T test case
        while (T-- > 0) { out.println(sumToN(in.nextLong())); }
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try                   { tokenizer = new StringTokenizer(reader.readLine()); }
                catch (IOException e) { throw new RuntimeException(e); }
            }
            return tokenizer.nextToken();
        }

        public int  nextInt()  { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}