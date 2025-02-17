package graphtheory;
/*
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = 7;
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);

        graph.get(2).add(0);
        graph.get(2).add(3);
        graph.get(2).add(4);

        graph.get(3).add(1);
        graph.get(3).add(2);

        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(4).add(6);

        graph.get(5).add(4);
        graph.get(5).add(6);

        graph.get(6).add(4);
        graph.get(6).add(5);

        int[] visited = new int[n];
        int[] insertion_time = new int[n];
        int[] minimum_insertion = new int[n];

        int count=1;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                getBridge(i,-1,visited,insertion_time,minimum_insertion,count,graph);
            }
        }
    }

    public static void getBridge(int node,int parent,int[] visited,int[] insertion_time,int[] minimum_insertion,int count,ArrayList<ArrayList<Integer>> graph){

        visited[node]=1;
        insertion_time[node] = minimum_insertion[node] = count++;
        for(int nbr:graph.get(node)){
            if(nbr==parent) continue;
            if(visited[nbr]==0){
                getBridge(nbr,node,visited,insertion_time,minimum_insertion,count,graph);
                minimum_insertion[node]=Math.min(minimum_insertion[node],minimum_insertion[nbr]);
                if(minimum_insertion[nbr]>insertion_time[node]){
                    System.out.println("Bridge edge is between Node "+nbr+" and Node "+node);
                }
            }
            else{
                minimum_insertion[node]=Math.min(minimum_insertion[node],insertion_time[nbr]);
            }
        }
    }
}
// This code is contributed by Aakash Hasija

*/

import javax.swing.UIManager;
import java.awt.Color;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Date date = new Date();
        new Canvas("Graph Theory SY08-09 Term3 by Team DGLSS v0.5 " + date.toString(), 1000, 600, Color.WHITE);

    }
}