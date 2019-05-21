/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructureAssignment;
import java.util.*; 
/**
 *
 * @author CFONe
 */
public class Djikstra {
    private int distance[];// array for distances for each node
    private int time[];
    private Set<Integer> settled;// a set for all the nodes that have been calculated
    private int V; //Number of nodes/vertices/neuron
    private PriorityQueue<Node> pq;
    List<List<Node> > adj; //list for adjacent nodes

    public Djikstra(int V) {
        this.V = V;
        distance = new int [V];
        time = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
        
    }
    
    public void calculate(List<List<Node>> adj, int src){//to calculate shortest distance using djikstra algo
        this.adj = adj;
        for(int i = 0; i<V ; i++)
            distance[i] = Integer.MAX_VALUE;
        for(int i = 0 ; i<V ; i++)
            time[i] = Integer.MAX_VALUE;
        
        pq.add(new Node(src,0,0));
        distance[src] = 0;
        time[src] = 0;
        
        while(settled.size() != V){
            int u = pq.remove().node;
            settled.add(u);
            neighbours(u);
        }
    }
    
    public void neighbours(int u){
        int edgeDist = -1;
        int edgeTime = -1;
        int newDist = -1;
        int newTime = -1;
        
        for(int i = 0; i<adj.get(u).size(); i ++){
            Node v =  adj.get(u).get(i);
            
            if(!settled.contains(v.node)){
                edgeDist = v.costD;
                edgeTime = v.costT;
                newDist = distance[u] + edgeDist;
                newTime = time[u]+ edgeTime;
             if(newTime<time[v.node])
                 time[v.node] = newTime;
             if(newDist<distance[v.node])
                 distance[v.node] = newDist;
             pq.add(new Node(v.node, distance[v.node], time[v.node]));
            }
        }
    }
    
    public static void main(String arg[]){
       int V = 5;
       int source = 0;
       
       List<List<Node>> adj = new ArrayList<List<Node>>();
       for( int i = 0 ; i< V; i++){
           List<Node> item = new ArrayList<Node>();
           adj.add(item);
       }
       
       adj.get(0).add(new Node(1,9,6));
       adj.get(0).add(new Node(2,6,4));
       adj.get(0).add(new Node(3, 4,1)); 
       adj.get(0).add(new Node(4, 3,3)); 
       adj.get(2).add(new Node(1, 2,1)); 
       adj.get(2).add(new Node(3, 1,4)); 
       adj.get(3).add(new Node(2, 1, 2));
  
       Djikstra test = new Djikstra(V);
       test.calculate(adj, source);
       
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < test.distance.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + test.distance[i]+ ", "+test.time[i]); 
   }
    
  
   
   
}

 class Node implements Comparator<Node> { 
    public int node; 
    public int costD; // cost for distance
    public int costT; // cost for time
    public Node() 
    { 
    } 
  
    public Node(int node, int distance, int time) 
    { 
        this.node = node; 
        this.costD = distance; 
        this.costT = time;
    } 
  
    @Override
    public int compare(Node node1, Node node2) //comparator to compare 2 nodes
    { 
        if (node1.costT < node2.costT) 
            return -1; 
        if (node1.costT > node2.costT) 
            return 1; 
        if(node1.costT == node2.costT){
            if (node1.costD< node2.costD) 
                return -1; 
            if (node1.costD > node2.costD) 
                return 1; 
            return 0;
        }
            
        return 0; 
    } 
}

