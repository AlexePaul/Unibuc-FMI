#include <queue>
#include <fstream>

using namespace std;

ifstream fin("bomboane.in");
ofstream fout("bomboane.out");

// trebuie sa creez acest comparator deoarece folosesc heap de pair<int,int> si trebuie sa precizez cum sa ordoneze
struct MinHeap{
    bool operator()(const pair<int,int> a, const pair<int,int> b){
        return a.first > b.first;
    }
};

struct MaxHeap{
    bool operator()(const pair<int,int> a, const pair<int,int> b){
        return a.first < b.first;
    }
};

struct Move{
    int S,D,B;
};

int main(){
    int n, sum = 0, avg;
    vector<int> v(1005);
    vector<Move> ans;

    priority_queue<pair<int, int>, vector<pair<int, int>>, MaxHeap> maxH;
    priority_queue<pair<int, int>, vector<pair<int, int>>, MinHeap> minH;

    fin >> n;
    for(int i = 0; i < n; i++){
        fin >> v[i];
        sum += v[i];
    }

    avg = sum / n;

    if(sum % n != 0){
        fout << -1 << endl;
        return 0;
    }

    for(int i = 0; i < n; i++){
        if(v[i] < avg)
            minH.push({v[i], i+1});
        if(v[i] > avg)
            maxH.push({v[i], i+1});    
    }

    while(maxH.size() != 0 && minH.size() != 0){
        pair<int,int> maxT = maxH.top();
        pair<int,int> minT = minH.top();
        maxH.pop();
        minH.pop();

        int valueToMove = min(avg - minT.first, maxT.first - avg);
        ans.push_back({maxT.second, minT.second, valueToMove});
        
        maxT.first -= valueToMove;
        minT.first += valueToMove;

        if(maxT.first > avg)
            maxH.push(maxT);
        if(minT.first < avg)
            minH.push(minT);

    }
    fout << ans.size() << '\n';
    for(int i = 0; i < ans.size(); i++){
        fout << ans[i].S << ' ' << ans[i].D << ' ' << ans[i].B << '\n';
    }
}