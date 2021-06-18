import java.util.*;

public class Graph {
    private static Vertex[] VerticesArray; //array of vertices objects
    private double[][] matrix; 
    int count = 0;
    private double[][] temp;
    private static int shortestP; //shortest path's linkedlist's index
    private static double minD; //minimum Distance

    Graph(int size) {
        //size is no. of vertices
        VerticesArray = new Vertex[size];
        matrix = new double[size][size];
    }

    public static Vertex[] getVerticesArray() {
        return VerticesArray;
    }

    public static int getShortestP() {
        return shortestP;
    }
    
    public static double getminD() {
        return minD;
    }

    public void addVertex(Vertex v) { 
        //Vertex object has index,name
        int index = v.getIndex(); 
        if (VerticesArray[index] == null) {
            VerticesArray[index] = v; 
        }
    }

    public void addEdge(int e1, int e2, double distance) { 
        if (matrix[e1][e2] == 0.00) {
            matrix[e1][e2] = distance;
        }
    }

    public int findVertex(String vertexName) { 
        //getting vertex index from VerticesArray
        for (int i = 0; i < VerticesArray.length; i++) {
            if (VerticesArray[i].getName().equals(vertexName)) {  
                return i;
            }
        }
        return -1; //not found
    }

    public ArrayList<Linkedlist> allPaths(String source, String destination) {
        //names of source, dest given
        shortestP = -1;
        minD = Double.POSITIVE_INFINITY;
        int start = findVertex(source); //finding index of source from VerticesArray
        int end = findVertex(destination); //finding index of dest from VerticesArray
        boolean[] visited = new boolean[8]; 
        ArrayList<Linkedlist> PathsArrlist = new ArrayList<Linkedlist>(); //arraylist of Linkedlists
        Queue<Linkedlist> q = new ArrayDeque<Linkedlist>();
        //ArrayDeque class is likely to be faster than LinkedList when used as a queue
        //Since Queue is an interface, objects cannot be created of the type queue.
        //We always need a class which extends this list in order to create an object   
        Linkedlist list = new Linkedlist();   
        list.addAsTail(start); //index of source added to linkedlist
        q.add(list);  //added linkedlist in queue
        while (!q.isEmpty()) {
            
            list = q.poll(); //removing head of queue
            
            if (list.tail.v == end) { //if tail of list is index of destination, we found a path to dest
                PathsArrlist.add(list);
                if (list.distance < minD) {
                    minD = list.distance; //shortest distance updated
                    shortestP = PathsArrlist.size() - 1; //stored index of the shortest path in PathArrlist
                }
            } else {
                //if tail of list is not index of destination
                int index = list.tail.v; //index number we had assigned to the vertex 
                int j = 0;
                int[] arr = new int[list.size];
                node temp = list.head;
                while (temp != null && j < arr.length) { // copying all nodes of the path into array
                    arr[j] = temp.v;
                    temp = temp.next;
                    j++;
                }
                visited[index] = true; //vertex marked visited 
                for (int i = 0; i < 8; i++) {   
                    if (visited[i] == true) {
                        continue;  //skip this iteration if visited
                    }
                    if (matrix[index][i] != 0.00) {   //where there is edge connected to the vertex
                        Linkedlist l = new Linkedlist(); 
                        for (int k = 0; k < arr.length; k++) {  
                            l.addAsTail(arr[k]); //old edges added in linklist
                        }
                        l.addAsTail(i); //new edge added in linklist
                        l.distance = list.distance + matrix[index][i]; 
                        q.add(l); 
                    }
                }
            }
        }
        return PathsArrlist;
       
    }

}
