import java.io.*;
import java.util.*;

public class BOJ20922_겹치는_건_싫어 {
	
	/**
	 * 21.3.3
	 * 
	 * 투 포인터 문제긴 했는데, 로직을 잘 짜두고 빼줄 때 개수를 -- 해주지 않아 한참 헤맸다.
	 * 
	 * 원래 풀려고 했던 방향으로 풀었지만, l,r을 가지고 두 포인터를 사용하는 풀이가 훨씬 깔끔해 보인다.
	 * 
	 */

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, room[], ans, numberRoom[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());

		room = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = stoi(st.nextToken());
		}

		numberRoom = new int[100001];

		int size = 0;
		int startIdx = 0;
		for (int i = 0; i < N; i++) {
			int num = room[i];
			if (numberRoom[num] < K) {
				numberRoom[num]++;
			} else {
				// 이미 해당 수가 K개 있다면,
				while (room[startIdx] != num) {
					numberRoom[room[startIdx++]]--;
				}
				startIdx++;
			}
			if (ans < (i - startIdx + 1)) {
				ans = i - startIdx + 1;
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