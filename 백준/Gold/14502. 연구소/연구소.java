import java.io.*;
import java.util.*;

class Pair{
    Integer y;
    Integer x;
    public Pair(Integer y, Integer x) {
        this.y = y;
        this.x = x;
    }
    public Integer first() {
        return y;
    }
    public Integer second() {
        return x;
    }
}

public class Main {
    static int N = 0, M = 0;
    static int [][]arr = new int[10][10];
    static int [][]visited = new int[10][10];
    static List<Pair> virusList = new LinkedList<Pair>();
    static List<Pair> wallList = new LinkedList<Pair>();
    static int res = 0;
    static int []dy = {-1,0,1,0};
    static int []dx = {0,1,0,-1};

    public static void initializeVisited() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = 0; // 각 요소를 0으로 설정
            }
        }
    }

    public static void dfs(int y, int x){
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M || arr[ny][nx] == 1 || visited[ny][nx] == 1 )
                continue;

            visited[ny][nx] = 1;

            dfs(ny, nx);
        }
    }

    public static int check() {
        initializeVisited();
        for(Pair virus : virusList){
            visited[virus.first()][virus.second()] = 1;
            dfs(virus.first(), virus.second());
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0 && visited[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) virusList.add(new Pair(i,j));
                if(arr[i][j] == 0) wallList.add(new Pair(i,j));
            }
        }

        for(int i = 0; i < wallList.size(); i++){
            for(int j = 0; j < i; j++){
                for(int k = 0; k < j ; k++){
                    arr[wallList.get(i).first()][wallList.get(i).second()] = 1;
                    arr[wallList.get(j).first()][wallList.get(j).second()] = 1;
                    arr[wallList.get(k).first()][wallList.get(k).second()] = 1;
                    int cnt = check();
                    res =  (cnt < res) ? res : cnt;

                    arr[wallList.get(i).first()][wallList.get(i).second()] = 0;
                    arr[wallList.get(j).first()][wallList.get(j).second()] = 0;
                    arr[wallList.get(k).first()][wallList.get(k).second()] = 0;
                }
            }
        }

        System.out.printf("%d", res);

        br.close();
    }
}