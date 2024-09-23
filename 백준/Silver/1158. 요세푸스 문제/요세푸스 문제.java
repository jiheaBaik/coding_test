import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<Integer>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.close();

        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while(list.size() > 1){
            index = (index + (K - 1)) % list.size();
            sb.append(list.remove(index)).append(", ");
        }
        System.out.println(sb.append(list.remove(0)) + ">");

    }
}