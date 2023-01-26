import java.util.*;

public class Bfs{
    //a class for storing the source and destination of the graph
    public static class Edge{
        int src;
        int dest;
        //a constructor to add as much edges as the user wants
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public void createGraph(ArrayList<Edge> graph[]){
        //for initializing the array with ArrayList
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        //adding the edges to th array by using the Edge class constructor
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

    }
    public static void bfs(ArrayList<Edge> graph[],boolean visited[],int start){
        //initailizing a queue of Integer type to traverse the graph
        Queue<Integer> q =new LinkedList<>();
        //adding the startin node to the queue
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.remove();//removing the element in the front form the queue and storing in the variable curr
            //checking that the node is visited or not bcoz at the time of initializing all the elements of the array are false
            if(visited[curr]==false){
                System.out.println(curr+" ");
                visited[curr]=true;
                //adding the neighbours of the node to the queue
                for(int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args){
        int V=7;//the size of the graph vertices
        ArrayList<Edge> graph[]=new ArrayList[V];//creating the ArrayList of array to perform all the operations on the graph
        Bfs b=new Bfs();
        b.createGraph(graph);
        //initializing an array with the number of nodes of graph, of boolean type to distinguish between the visited and unvisited nodes of a graph 
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                bfs(graph,visited,i);
            }
        }
        
         /*
               1 --- 3
             /       | \ 
            0        |   5 -- 6
             \       | /
               2 --- 4 


         */
    }
}
