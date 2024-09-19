import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> deque = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();// 뽑고자 하는 수 list

        int count = 0;

        int N = sc.nextInt();// 큐의 크기(1 ~ N)
        int M = sc.nextInt();// 뽑으려는 숫자의 개수

        // 1부터 N까지 덱에 담아둔다.
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        for (int i = 0; i < M; i++) {
            nums.add(sc.nextInt());
        }

        for (int i = 0; i < M; i++) {

            int index = deque.indexOf(nums.get(i));
            int half_index;
            
            half_index = deque.size() / 2;

            // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
            if (index <= half_index) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 방법 연산)
                for (int j = 0; j < index; j++) {
                    //pollFirst() : 리스트의 첫 요소 가져와서 삭제
                    // LikedList의 첫 번째 요소를 반환하면서 제거
                    // 리스트가 비어있으면 null 리턴
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }
            else {    // 중간 지점보다 원소의 위치가 뒤에 있는 경우
                // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 방법  연산)
                for (int j = 0; j < deque.size() - index; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }

            deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제

        }

        System.out.println(count);
    }
}