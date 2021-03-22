import java.io.*;
import java.util.*;

public class BOJ1495_기타리스트 {

	/**
	 * 21.3.23
	 * 
	 * 재미있는 DP 문제 였다. n이 100까지고 m이 1000까지 이므로, O(nm)으로 풀이해도 무리가 없는 문제였다.
	 *
	 */
	
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, S, M, V[], ans;
	static boolean dp[][];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		S = stoi(st.nextToken());
		M = stoi(st.nextToken());
		dp = new boolean[N][M + 1];
		V = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			V[i] = stoi(st.nextToken());
		}
		if (S - V[0] >= 0) {
			dp[0][S - V[0]] = true;
		}
		if (S + V[0] <= M) {
			dp[0][S + V[0]] = true;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= M; j++) {
				if (dp[i - 1][j]) {
					if (j - V[i] >= 0) {
						dp[i][j - V[i]] = true;
					}
					if (j + V[i] <= M) {
						dp[i][j + V[i]] = true;
					}
				}
			}
		}
		ans = -1;
		for (int i = M; i >= 0; i--) {
			if (dp[N - 1][i]) {
				ans = i;
				break;
			}
		}
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}