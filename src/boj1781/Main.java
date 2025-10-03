package boj1781;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Problem[] problems = new Problem[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            problems[i] = new Problem(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }


        // 우선순위큐로
        // 데드라인이 낮고 벨류가 높은걸 우선
        // 요소 하나 넣을때마다 타임 추가


        // 정답 리스트는 민힙으로 관리
        // 시간이 넘은 경우에는
        // 가장 작은애랑 교체

        Long result = 0L;
        int time = 0;

        PriorityQueue<Problem> pq = new PriorityQueue<>((a, b) -> {
            if (a.dead - b.dead == 0) {
                return b.value - a.value;
            }
            return a.dead - b.dead;
        });
        Collections.addAll(pq, problems);
        PriorityQueue<Problem> resultPq = new PriorityQueue<>((a,b)-> {
            return a.value - b.value;
        });


        while (!pq.isEmpty()) {
            var p = pq.poll();

            if (time < p.dead) {
                result += p.value;
                time++;
                resultPq.add(p);
            } else if (!resultPq.isEmpty() && resultPq.peek().value < p.value) {
                var minP = resultPq.poll();
                result -= minP.value;
                result += p.value;
                resultPq.add(p);
            }
        }

        System.out.println(result);
    }

    static class Problem {
        int dead;
        int value;

        public Problem(int dead, int value) {
            this.dead = dead;
            this.value = value;
        }
    }
}
