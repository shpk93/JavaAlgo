package boj21276;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> indegree = new HashMap<>();
    static Map<String, List<String>> result = new HashMap<>();

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = st.nextToken();
        }
        
        for (String input : inputs) {
            graph.put(input, new ArrayList<>());
            result.put(input, new ArrayList<>());
            indegree.put(input, 0);
        }


        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            indegree.put(a, indegree.get(a) + 1);
            graph.get(b).add(a);
        }

        List<String> result1 = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();

        for (var entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                result1.add(entry.getKey());
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String next : graph.get(cur)) {

                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.add(next);
                    result.get(cur).add(next);

                }
            }
        }
        Arrays.sort(inputs);
        Collections.sort(result1);
        StringBuilder out = new StringBuilder();

        out.append(result1.size()).append("\n");
        for (String parent : result1) {
            out.append(parent).append(" ");
        }
        out.append("\n");


        Arrays.sort(inputs);

        for (String name : inputs) {
            List<String> tmp = result.get(name);
            Collections.sort(tmp);

            out.append(name).append(" ").append(tmp.size()).append(" ");
            for (String name2 : tmp) {
                out.append(name2).append(" ");
            }
            out.append("\n");
        }

        System.out.println(out);
    }
}
