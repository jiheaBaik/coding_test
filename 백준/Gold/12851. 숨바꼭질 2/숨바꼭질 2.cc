#include<iostream>
#include<queue>
using namespace std;
int n, k;
int visited[100001];
int cnt[100001];
queue<int> q;

int main()
{
    cin >> n >> k;
    //동생과 위치가 같을 경우
    if(n == k)
    {
        cout << 0 << '\n' << 1;
        return 0;
    }
    
    q.push(n);
    visited[n] = 1;
    cnt[n] = 1;
    
    while(!q.empty())
    {
        int x = q.front();
        q.pop();
        for(int i = 0; i < 3; i++)
        {
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
            if(visited[nx])
            {
                //최단 거리 경우에만
                if(visited[nx] == visited[x] + 1)
                    cnt[nx] += cnt[x];
            }
            else
            {
                visited[nx] = visited[x] + 1;
                cnt[nx] += cnt[x];
                 q.push(nx);
            }         
        }
    }
    //시간 구하기는 -1
    cout << visited[k] -1 << '\n' << cnt[k];
    return 0;
}