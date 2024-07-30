import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] arr = new char[H][W];

        for(int i = 0; i < H; i++){
            String str = br.readLine();
            for(int j = 0; j < W; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < H; i++){
            boolean flag = false;
            int time = 0;

            for(int j = 0; j < W; j++){
                if(arr[i][j] == 'c'){
                    flag = true;
                    time = 0;
                    bw.write(0 + " ");
                }
                else{
                    if(!flag)
                        bw.write(-1 + " ");
                    else{
                        time++;
                        bw.write(time + " ");
                    }
                }
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();

    }
}