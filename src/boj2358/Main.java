package boj2358;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> xHash = new HashMap<>();
        Map<Integer, Integer> yHash = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int y = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);

            // x는 첫 등장 0, 그다음부터 +1 (중복 횟수 저장)
            xHash.put(x, xHash.getOrDefault(x, 0) + (xHash.containsKey(x) ? 1 : 0));

            // y도 동일하게
            yHash.put(y, yHash.getOrDefault(y, 0) + (yHash.containsKey(y) ? 1 : 0));
        }

        int cnt = 0;
        for (int v : yHash.values()) if (v > 0) cnt++;
        for (int v : xHash.values()) if (v > 0) cnt++;

        System.out.println(cnt);
    }
}