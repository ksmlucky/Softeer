// Softeer - 지도 자동 구축
// https://softeer.ai/practice/info.do?eventIdx=1&psProblemId=413

import java.io.IOException;
import java.util.Scanner;

public class Softeer_Num413_지도자동구축 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        long temp = 1;

        for (int i = 0; i < N; i++) {
            temp *= 2;
        }
        temp++;

        System.out.println(temp * temp);
    }
}
