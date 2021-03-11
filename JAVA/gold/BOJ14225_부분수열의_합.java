import java.io.*;
import java.util.*;

public class BOJ14225_부분수열의_합 {

	
	/**
	 * 21.3.12
	 * 
	 * nC0+nC1+nC2+...+nCn의 합은 2^n임을 알아두기! 코테 다 뚫어버리자.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, S[], ans;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		set = new HashSet<Integer>();
		S = new int[N];
		for (int i = 0; i < N; i++) {
			S[i] = stoi(st.nextToken());
		}

		// nC1 + nC2... +nCn은 2^n과 같다. 여기서 N은 20까지니까 완탐으로 가능.

		for (int i = 1; i <= N; i++) {
			search(i, 0, 0, 0);
		}
		for (int i = 1;; i++) {
			if (!set.contains(i)) {
				ans = i;
				break;
			}
		}
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static void search(int cnt, int nowCnt, int idx, int sum) {
		if (cnt == nowCnt) {
			set.add(sum);
			return;
		}
		for (int i = idx; i < N; i++) {
			sum += S[i];
			search(cnt, nowCnt + 1, i + 1, sum);
			sum -= S[i];
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}