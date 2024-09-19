import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
           nums.add(sc.nextInt());
            //nums.add(Integer.parseInt(sc.next()));
        }

        List<Stack<Integer>> stList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            stList.add(new Stack<>());
        }

        String result = "NO";

        for (int num : nums) {
            result = "NO";
            for (Stack<Integer> integers : stList) {
                if (integers.isEmpty() || integers.peek() < num ) {
                    integers.push(num);
                    result = "YES";
                    break;
                }
            }

            //stack을 다 돌았는데도 NO라면
            if (result.equals("NO")) {
                break;
            }
        }

        System.out.println(result);

    }
}