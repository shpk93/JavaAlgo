package boj2457;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int start = 100 * Integer.parseInt(line[0]) + Integer.parseInt(line[1]);
            int end = 100 * Integer.parseInt(line[2]) + Integer.parseInt(line[3]);
            list.add(new Flower(start, end));
        }

        System.out.println(solution(list));

    }

    public static int solution(List<Flower> list) {
        int result = 0;

        list.sort((a, b) -> {
            if (a.start == b.start) return a.end - b.end;
            return a.start - b.start;
        });
        list = list.stream().filter((f) -> {
            if (301 >= f.end) return false;
            return f.start <= 1130;
        }).map(x -> {
            if (x.start < 301) return new Flower(301, x.end);
            return x;
        }).collect(Collectors.toList());

//        System.out.println(list);
        if (list.isEmpty()) return 0;
        int max = 301;

        // 정렬하고
        // 먼저 301일 1130 조건 필터치고
        // 요소를 돌면서
        // max 보다 start가 낮으면 바로 return 0;
        // max가 end보다 크면 skip
        // 이 요소부터 다시 순회해서 현재 기준으로 만족되는 가장 큰 max값으로 갱신

        for (int i = 0; i < list.size(); i++) {
            var f = list.get(i);
            if (max < f.start) return 0;
            if (max > f.end) continue;
            if (max > 1130) break;

            var tmp = f;
//            System.out.println("들어간시점" + max);

            for (int j = i + 1; j < list.size(); j++) {
                var f2 = list.get(j);
//                System.out.println("도는중" + f2);

                if (max >= f2.start && tmp.end < f2.end) {
                    tmp = f2;
                    i = j;
                } else if(tmp.end >= f2.end){
                    i = j;
                } else break;
            }
//            System.out.println(tmp);
            max = tmp.end;
            result++;
        }
        if (max <= 1130) return 0;

        return result;
    }


    public static class Flower {
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + this.start + ", " + this.end + "]";
        }
    }
}
