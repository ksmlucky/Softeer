// Softeer - [21년 재직자 대회 예선] 회의실 예약
// https://softeer.ai/practice/info.do?eventIdx=1&psProblemId=626

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num626_회의실예약 {
    static String[] strArr;
    static boolean[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        strArr = new String[N];
        time = new boolean[N][18];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            useRoom(getRoomName(str), start, end);
        }

        // 출력
        for (int i = 0; i < N; i++) {
            sb.append("Room ").append(strArr[i]).append(":").append("\n");
            sb.append(timeCheck(i));
            sb.append("-----").append("\n");
        }
        sb.setLength(sb.length() - 7);


        System.out.println(sb);
    }

    private static String timeCheck(int index) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append("");
        sb2.append("");
        int start = 0, end = 0;
        boolean flag = false;
        int count = 0;
        for (int i = 9; i < 18; i++) {
            if (!flag && !time[index][i]) {
                flag = true;
                start = i;
            } else if (flag && time[index][i]) {
                flag = false;
                end = i;
                if (start == 9) {
                    sb2.append("0" + start).append("-").append(end).append("\n");
                } else {
                    sb2.append(start).append("-").append(end).append("\n");
                }

                count++;
            }
        }
        if (flag == true) {
            if (start == 9) {
                sb2.append("0" + start).append("-").append(18).append("\n");
            } else {
                sb2.append(start).append("-").append(18).append("\n");
            }
            count++;
        }

        if (count == 0) {
            sb1.append("Not available\n");
        } else {
            sb1.append(count + " available:\n");
        }
        sb1.append(sb2);

        return sb1.toString();
    }

    private static int getRoomName(String str) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }

        return 0;
    }

    private static void useRoom(int roomNum, int start, int end) {
        for (int i = start; i < end; i++) {
            time[roomNum][i] = true;
        }
    }
}
