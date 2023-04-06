#include<iostream>
#include<chrono>
using namespace std::chrono;
using namespace std;

class Node {
    public:
    int data;
    Node* next;
    Node(int x){
        data=x;
        next=NULL;
    }
};

class Stack {
    private:
    Node* top;
    public:
    Stack(){
        top=NULL;
    }

    void Push(int x){
        Node* temp=new Node(x);
        temp->next=top;
        top=temp;
    }

    void Pop(){
        if(top==NULL){
            cout<<"Error. Stack Underflow";
        }
        else{
            Node* temp=top;
            top=top->next;
            delete temp;
        }
    }
    bool isEmpty(){
        return top==NULL;
    }

    bool isFull(){
        Node* temp=new Node(0);
        if(temp==NULL){
            return true;
        }
    }

    int StackTop(){
        return top->data;
    }

    void Display(){
        Node* temp=top;
        while(temp!=NULL){
            cout<<temp->data<<" ";
            temp=temp->next;
        }
        cout<<endl;
    }
};

int main(){
    Stack S;
    auto start = high_resolution_clock::now();
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

	cout << "Time taken by Linked List: "
		<< duration.count() << " microseconds" << endl;
        
    return 0;
}
