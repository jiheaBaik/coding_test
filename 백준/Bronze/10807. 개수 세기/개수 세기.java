import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> number = new HashMap<>();
        //  StringTokenizer는 공백을 기준으로 문자열을 분할
        StringTokenizer strtk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            int target = Integer.parseInt(strtk.nextToken());

            if (number.containsKey(target)) {
                number.put(target, number.get(target) + 1);
            } else {
                number.put(target, 1);
            }

        }

        int v = Integer.parseInt(br.readLine());
        
        if(number.get(v) == null)
            System.out.println(0);
        else 
            System.out.println(number.get(v));
        
    }
}