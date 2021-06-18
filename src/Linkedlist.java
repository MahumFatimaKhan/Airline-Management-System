public class Linkedlist {
    //doubly linked list
    node head;
    node tail;
    double distance = 0;
    int size = 0; //to know how many linkedlist we've added

    void addAsTail(int v) {  
        node n = new node(v);
        if (head == null) {
            head = n;
        }
        if (tail == null) {
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++; 
    }

}

class node {
    int v;
    node next;

    node(int v) {
        this.v = v;
    }
}
