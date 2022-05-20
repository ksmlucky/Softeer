// Softeer - 바이러스
// https://softeer.ai/practice/info.do?eventIdx=1&psProblemId=407

import java.util.*;
import java.io.*;

public class Softeer_Num407_바이러스 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();
        long P = sc.nextLong();
        long N = sc.nextLong();

        for (int i = 0; i < N; i++) {
            K = (K * P) % 1000000007;
        }

        System.out.println(K);

//        System.out.println((long)(K * Math.pow(P, N)) % 1000000007);

    }
}
