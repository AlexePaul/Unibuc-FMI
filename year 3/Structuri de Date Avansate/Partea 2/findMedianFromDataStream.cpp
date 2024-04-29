#include <queue>

using namespace std;

class MedianFinder {
    priority_queue<int> inceput; 
    priority_queue <int, vector<int>, greater<int> > sfarsit;
public:
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(inceput.size() == 0){
            inceput.push(num);
            return;
        }
        if(inceput.top() > num){
            inceput.push(num);
            while(inceput.size() > sfarsit.size()){
                int nr = inceput.top();
                inceput.pop();
                sfarsit.push(nr);
            }
            return;
        }
        else{
            sfarsit.push(num);
            while(sfarsit.size() > inceput.size()){
                int nr = sfarsit.top();
                sfarsit.pop();
                inceput.push(nr);
            }
        }
    }
    
    double findMedian() {
        while(inceput.size() > sfarsit.size()){
                int nr = inceput.top();
                inceput.pop();
                sfarsit.push(nr);
            }
        while(sfarsit.size() > inceput.size()){
                int nr = sfarsit.top();
                sfarsit.pop();
                inceput.push(nr);
            }
        if(inceput.size() == sfarsit.size())
            return (double) (inceput.top() + sfarsit.top()) / 2;
        else
            return (double) inceput.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */