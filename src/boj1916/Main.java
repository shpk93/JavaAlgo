package boj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<Edge>> graph = new ArrayList<>();
    static List<Integer> visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            String line = br.readLine();
            int[] intLine = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(intLine));
            int from = intLine[0];
            int to = intLine[1];
            int cost = intLine[2];

            graph.get(from).add(new Edge(to,cost));
        }

        System.out.println(graph);

    }

    private static String solution() {
        return "";
    }

    static class Edge implements Comparable<Edge>{
        int to;
        int cost;
        Edge(int to,int cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge anotherEdge){
            return this.cost - anotherEdge.cost;
        }
    }
}
