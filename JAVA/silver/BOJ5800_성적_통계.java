import java.io.*;
import java.util.*;

public class BOJ5800_성적_통계 {

	/**
	 * 21.3.24
	 * 
	 * 출력은 참 귀찮다... 기본적인 정렬 문제.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int K, N, room[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = stoi(br.readLine());
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			room = new int[N];
			for (int j = 0; j < N; j++) {
				room[j] = stoi(st.nextToken());
			}
			Arrays.sort(room);
			int sub = 0;
			for (int j = 0; j < N - 1; j++) {
				if (room[j + 1] - room[j] > sub) {
					sub = room[j + 1] - room[j];
				}
			}
			bw.append("Class ").append(String.valueOf(i)).append('\n').append("Max ")
					.append(String.valueOf(room[N - 1])).append(", Min ").append(String.valueOf(room[0]))
					.append(", Largest gap ").append(String.valueOf(sub)).append('\n');
		}

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}