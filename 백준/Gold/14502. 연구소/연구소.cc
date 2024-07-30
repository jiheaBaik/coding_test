#include<bits/stdc++.h>
using namespace std;
int n, m, res;
int bg[10][10],visited[10][10];
vector<pair<int, int>> virusList, wallList;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
void dfs(int y, int x)
{
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || bg[ny][nx] == 1) 
            continue;
        
        visited[ny][nx] = 1;
        dfs(ny, nx);
    }
    return;
}
int solve()
{
    fill(&visited[0][0], &visited[0][0] + 10 * 10, 0);
    for(pair<int, int> b : virusList){
        visited[b.first][b.second] = 1;
        dfs(b.first, b.second);
    } 
     int cnt = 0;
     for(int i = 0; i < n; i++){
       for(int j = 0; j < m; j++){
           if(bg[i][j] == 0 && !visited[i][j])
               cnt++;
        }
     }
         return cnt;  
}
int main()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            cin >> bg[i][j];
            if(bg[i][j] == 2) virusList.push_back({i,j});
            if(bg[i][j] == 0) wallList.push_back({i,j});
        }
    }
    
    for(int i = 0; i < wallList.size(); i++){
        for(int j = 0; j < i; j++){
            for(int k = 0; k < j; k++){
                bg[wallList[i].first][wallList[i].second] = 1;
                bg[wallList[j].first][wallList[j].second] = 1;
                bg[wallList[k].first][wallList[k].second] = 1;
                res = max(res, solve());
                bg[wallList[i].first][wallList[i].second] = 0;
                bg[wallList[j].first][wallList[j].second] = 0;
                bg[wallList[k].first][wallList[k].second] = 0;
            }
        }
    }
    cout << res << "\n";
    return 0;
}