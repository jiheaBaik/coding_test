import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {

            boolean flag = true;
            Stack<Character> stk = new Stack<Character>();

            String str = br.readLine();
            for (char c : str.toCharArray()) {
                if (c == '(')
                    stk.push(c);

                if (stk.isEmpty() && c == ')') {
                    flag = false;
                    break;
                }

                if (c == ')')
                    stk.pop();

            }

            if (flag && stk.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}