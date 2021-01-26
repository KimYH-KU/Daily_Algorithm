import java.io.*;
import java.util.*;

public class BOJ2042_구간_합_구하기 {

	/**
	 * 2020.01.22 
	 * 
	 * 원래 붙잡고 있던 문제를 못 풀어서 이 문제로 수정하였다. 세그먼트 트리의 개념에 대해 물어보는 문제
	 * 
	 * update 시에는 아래로 내려가면서 부모까지 update 해줘야 하며, query에 대해서는 부모가 구간에 걸릴 경우 더이상 내려갈 필요 없이 해당 부분의 수를 더해주면 된다.
	 * 
	 */
	
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, K;
	static long room[], tree[];
	static int size;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		int cnt = 0;
		int copyN = N;
		while (copyN > 0) {
			cnt++;
			copyN /= 2;
		}
		size = (1 << cnt);
		tree = new long[2 * size];
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			update(i, num, 1, 0, size - 1);
		}
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = stol(st.nextToken());
			long b = stol(st.nextToken());
			long c = stol(st.nextToken());
			if (a == 1) {
				// b번째를 c로 변경, update 필요. 그리고 1부터 이기 때문에 1 빼주는 거임.
				update(--b, c, 1, 0, size - 1);
			} else {
				// b부터 c까지의 합, query 필요.
				bw.append(String.valueOf(query(--b, --c, 1, 0, size - 1)) + '\n');
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static long query(long n1, long n2, int bit, int s, int e) {
		int m = (s + e) >> 1;
		if (n2 < n1 || n2 < s || e < n1)
			return 0; // 덧셈의 항등원.
		if (n1 <= s && e <= n2) // 완전히 해당 범위에 포함된다면,
			return tree[bit];
		return query(n1, n2, 2 * bit, s, m) + query(n1, n2, 2 * bit + 1, m + 1, e);
	}

	static void update(long n, long num, int bit, int s, int e) {
		int m = (s + e) >> 1;
		if (s == e) { // 리프 노드라는 뜻.
			tree[bit] = num;
			return;
		}

		if (n <= m) { // 왼쪽 자식의 구간이라는 뜻,
			update(n, num, 2 * bit, s, m);
		} else { // 얘는 오른쪽. 비트 이동은 자식이라고 가정했을때, 2를 곱하면 왼쪽, +1하면 오른쪽 임을 이용
			update(n, num, 2 * bit + 1, m + 1, e);
		}

		tree[bit] = tree[2 * bit] + tree[2 * bit + 1]; 
	}

	static Long stol(String s) {
		return Long.parseLong(s);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
