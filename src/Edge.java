public class Edge {
    Vertex src;
    Vertex des;
    int dis=0;
    
    public Edge(Vertex src, Vertex des, int dis){
        this.src = src;
        this.des = des;
        this.dis = dis;
    }
}
