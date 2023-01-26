import java.util.*;
public class Path {
    public static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++)
            graph[i]=new ArrayList<Edge>();
        
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

    public static void allPath(ArrayList<Edge> graph[],boolean vis[],int curr,String path,int tar){
       if(curr==tar){
        System.out.println(path);
        return;
       }
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                vis[curr]=true;
                allPath(graph,vis,e.dest,path+e.dest,tar);
                vis[curr]=false;
            }
        }
        /* if(vis[curr]==false && curr!=tar){
            path=path+curr;
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(vis[e.dest]==false && e.dest!=tar){
                   // path=path+e.dest;
                    vis[e.dest]=true;
                    allPath(graph,vis,e.dest,path,tar);
                    vis[e.dest]=false;
                }
            }
        }
        else{
            System.out.println(path);
            return;
        } */

    }

    public static void main(String[] args){
        /* int V=7;
        Scanner ss=new Scanner(System.in);
        String path="";
        ArrayList<Edge> graph[] =new ArrayList[V];
        boolean vis[]=new boolean[V];
        createGraph(graph);
        System.out.println("Enter the source node\n");
        int source=ss.nextInt();
        System.out.println("Enter the target node\n");
        int tar=ss.nextInt();
            allPath(graph,vis,source,"0",tar);
        ss.close(); */
        int V=7;
        Scanner ss=new Scanner(System.in);
        ArrayList<Edge> graph[]=new ArrayList[V];
        boolean vis[]=new boolean[V];
        createGraph(graph);
        System.out.println("Enter the source node\n");
        int source=ss.nextInt();
        System.out.println("Enter the target node\n");
        int tar=ss.nextInt();
        allPath(graph,vis,source,"0", tar);
    }
}
