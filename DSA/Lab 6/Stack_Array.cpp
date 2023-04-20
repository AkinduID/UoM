#include<iostream>
#include<chrono>
using namespace std::chrono;
using namespace std;

class Stack {

    private:

        int top;
        int size;
        int* array;

    public:

    Stack(){
        top=-1;
    }

    void setSize(int x){
        size=x;
        array=new int[size];
    }

    void Push(int x){
        //top=top+1;
        if(top>size-1){
            cout<<"Error. Stack Overflow";
        }
        else{
            top=top+1;
            array[top]=x;
        }
    }

    void Pop(){
        if(top==-1){
            cout<<"Error. Stack Underflow";
        }
        else{
            top=top-1;
            cout<< array[top+1]<<endl;
        }
    }

    bool isEmpty(){
        return top==-1;
    }

    void Display(){
        for(int i=0;i<=top;i++){
            cout<<array[i]<<" ";
        }
        cout<<endl;
    }

    bool isFull() {
        if (top == size - 1) {
            return true;
        }
    }
        
    int StackTop(){
        return array[top];
    }
};

int main() {
    Stack S;
    auto start = high_resolution_clock::now();
    S.setSize(10);
    S.Push(8);
    S.Push(10);
    S.Push(5);
    S.Push(11);
    S.Push(15);
    S.Push(23);
    S.Push(6);
    S.Push(18);
    S.Push(20);
    S.Push(17);
    S.Display();
    S.Pop(); //1
    S.Pop(); //2
    S.Pop(); //3
    S.Pop(); //4
    S.Pop(); //5
    S.Display();
    S.Push(4); 
    S.Push(30);
    S.Push(3);
    S.Push(1);
    S.Display();
    auto stop = high_resolution_clock::now();

	auto duration = duration_cast<microseconds>(stop - start);

	cout << "Time taken by Array: "
		<< duration.count() << " microseconds" << endl;
        
    return 0;
}
