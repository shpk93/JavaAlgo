package boj2623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] indegrees = new int[N + 1];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            edges.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int tmp = -1;
            for (int j = 0; j < t; j++) {
                if (j == 0) {
                    tmp = Integer.parseInt(st.nextToken());
                    continue;
                }
                int indegree = Integer.parseInt(st.nextToken());
                indegrees[indegree]++;
                edges.get(tmp).add(indegree);
                tmp = indegree;
            }
        }

        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;

        for (int i = 1; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.append(cur).append("\n");
            count++;
            for (int nv : edges.get(cur)) {
                indegrees[nv]--;
                if (indegrees[nv] == 0) {
                    queue.add(nv);
                }
            }

        }

        if(count != N) {
            System.out.println(0);
        } else System.out.println(result);
    }
}
