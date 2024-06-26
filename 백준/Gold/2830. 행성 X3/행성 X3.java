import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //1,000,000을 이진수로 표현하면 11110100001001000000
        //따라서 1,000,000 이하의 수를 이진수로 나타내기 위해서는 최대 20비트가 필요
        int[] countOneBits = new int[20];

        //1 갯수 저장
        for (int i = 0; i < n; i++) {

            int name = Integer.parseInt(br.readLine());

            for (int j = 0; j < 20; j++) {
                if ((name & (1 << j)) != 0) { // 1이 존재하면 +1
                    countOneBits[j]++;
                }
            }
        }

       //친밀도 구하기
        //XOR 값 = (0의 개수 * 1의 개수) * 비트 위치의 값
        //0의 개수와 1의 개수를 곱하는 것은 해당 비트 위치에서 0과 1이 조합되는 경우의 수
        long answer = 0;
        for (int i = 0; i < 20; i++) { // 자리 수 마다 친밀도 구하기
            long zeroCount = n - countOneBits[i]; // 0의 개수
            long oneCount = countOneBits[i]; // 1의 개수
            answer += zeroCount * oneCount * (1 << i); // 비트 위치 반영하여 값 구함
        }

        System.out.println(answer);

    }
}