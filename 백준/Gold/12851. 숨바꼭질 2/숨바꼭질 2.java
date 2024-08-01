import java.io.*;
import java.util.*;

public class Main {
    static int N = 0, K = 0;
    static int []visited  = new int[100001];
    static int []cnt = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //수빈이가 있는 위치
        N = Integer.parseInt(st.nextToken());
        //동생이 있는 위치 K
        K = Integer.parseInt(st.nextToken());

        if(N == K)
        {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(N);
        visited[N] = 1;
        cnt[N] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i = 0; i < 3; i++){
                int nx = 0;
                if(i == 0)
                    nx = x - 1;
                if(i == 1)
                    nx = x + 1;
                if(i == 2)
                    nx = x * 2;

                if(nx < 0 || nx > 100000)
                    continue;

                //이미 방문한 곳

                //최단 거리 카운팅 :
                //기존이 1이고 다른 곳에서 1로 왔으면 서로 더해서 1
                //만약 또 다른 곳에서 왔다면 또 더해서 총 3이 된다.
                //깔끔하게 최단거리 노드위치에서 총 카운팅이 된다.
                //만약 이미 방문한 곳이다 ?
                //→ 그렇다면 최단 거리인지 비교해야 한다.완전 탐색이기 때문에 최단 거리가
                //아닐 수도 있는데 더해버리면 엉망진창이기 때문이다.
                //즉, 자신의 위치에서 거리 + 1 할거기 때문에
                ////그 위치가 다음 노드로 갈 nx의 카운팅과 자신의 위치에서 거리 + 1 와 같다면
                //서로 최단 거리이기 때문에 더해주는 것이다.

                //가장 빠른 시간으로 찾는 방법이 몇 가지 인지
                //먼저 방문한 곳이 최단 거리이므로
                //이미 방문 한곳은 최단 거리가 같아야 갯수를 더하기 때문
                //방문할 곳이 현재 방문한 곳 + 1 이라면 => 최단거리


                if(visited[nx] != 0) {
                    //최단 거리 경우에만
                    if(visited[nx] == visited[x] + 1)
                        cnt[nx] += cnt[x];
                }
                else {
                    //현재 도착 지점이 젤 빨리 간 경우이므로 더해줌
                    visited[nx] = visited[x] + 1;
                    cnt[nx] += cnt[x];
                    q.add(nx);
                }
            }
        }

        //수빈이가 동생을 찾는 가장 빠른 시간
        //시간 구하기는 -1
        System.out.println(visited[K] - 1);

        //가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수
        System.out.println(cnt[K]);

        br.close();
    }
}