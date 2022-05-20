// Softeer - 장애물 인식 프로그램
// https://softeer.ai/practice/info.do?eventIdx=1&psProblemId=409

import java.util.*;
import java.io.*;

public class Softeer_Num409_장애물인식프로그램 {
    static int[][] map; // 입력 받는 map
    static int[][] realMap; // 블록에 번호를 기록할 map
    static int count = 0; // 블록 개수 count
    static int N;
    // 사방 탐색
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        realMap = new int[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // dfs 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) { // 장애물이면 해당 장애물에서 dfs 시작
                    count++; // 블록의 개수 +1
                    dfs(i, j);
                }
            }
        }

        int[] answerArr = new int[count]; // 블록의 개수 만큼의 크기를 갖는 정답 출력을 위한 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (realMap[i][j] != 0) { // 0이 아니면 블록이므로
                    answerArr[(realMap[i][j] - 1)]++; // 블록의 번호에 해당하는 인덱스의 요소를 1씩 증가
                }
            }
        }

        Arrays.sort(answerArr); // 크기순 정렬

        // 출력
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(answerArr[i]);
        }
    }

    private static void dfs(int r, int c) {
        map[r][c] = 0; // 방문 체크라고 봐도 됨
        realMap[r][c] = count; // 블록의 번호로 채워줌
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 벗어나면 continue
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0) {
                continue;
            }

            // 붙어있는 장애물이면 dfs
            if (map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}
