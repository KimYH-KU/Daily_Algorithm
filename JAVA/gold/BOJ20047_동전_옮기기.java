import java.io.*;
import java.util.*;

public class BOJ20047_동전_옮기기 {

	/**
	 * 21.02.01
	 * 
	 * 생각하는데 세 달이 걸린 문제였다. 위치가 바뀌는 동전과, 아닌 동전을 나누어서 N-2개와 2개의 prefix를 더해가며 문제를 해결하였다.
	 * 
	 * 마지막에 N개에서 가능하다면 정답. top-down 으로도 풀어보기.
	 * 
	 */
	
	static int N;
	static String S, T, cS;
	static char roomS[], roomT[], room[];
	static boolean dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		S = br.readLine();
		roomT = br.readLine().toCharArray();
		room = new char[2];
		int a, b;
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = stoi(st.nextToken());
		b = stoi(st.nextToken());
		StringBuilder sb = new StringBuilder();
		room[0] = S.charAt(a);
		room[1] = S.charAt(b);
		for (int i = 0; i < N; i++) {
			if (i == a || i == b)
				continue;
			sb.append(S.charAt(i));
		}
		roomS = sb.toString().toCharArray();
		dp = new boolean[N + 1][3];
		if (roomS[0] == roomT[0])
			dp[1][0] = true;
		if (room[0] == roomT[0])
			dp[0][1] = true;
		for (int i = 1; i < N; i++) {
			if (dp[i][0]) {
				if (i < N - 2 && roomS[i] == roomT[i])
					dp[i + 1][0] = true;
				if (room[0] == roomT[i])
					dp[i][1] = true;
			}
			if (dp[i - 1][1]) {
				if (i < N - 1 && roomS[i - 1] == roomT[i])
					dp[i][1] = true;
				if (room[1] == roomT[i])
					dp[i - 1][2] = true;
			}
			if (i > 1 && dp[i - 2][2]) {
				if (roomS[i - 2] == roomT[i])
					dp[i - 1][2] = true;
			}
		}
		if (dp[N][0] || dp[N - 1][1] || dp[N - 2][2])
			bw.append("YES");
		else
			bw.append("NO");
		bw.flush();
		br.close();
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}