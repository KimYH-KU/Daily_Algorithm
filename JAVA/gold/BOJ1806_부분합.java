import java.io.*;
import java.util.*;

public class BOJ1806_부분합 {

	/**
	 * 21.3.11
	 * 
	 * 투 포인터 문제라는 걸 알았지만 풀이에 시간이 오래 걸렸다.
	 * 
	 * l,r을 쓰는 문제에서 일단 합을 더할때는 r을 ++ 하면서 더해주면 된다.
	 * 
	 * S보다 크거나 같을 때 처리를 잘해줘야 하는데, 같다면 그냥 ++r 해주면 된다.
	 * 
	 * 크다면, 왼쪽 녀석을 빼주고 l++ 해준다. 연속되기 때문에 구간의 길이는 r-l+1로 계산 가능. 좋은 문제다.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, S, room[], sum, tmp, ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		S = stoi(st.nextToken());
		room = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = stoi(st.nextToken());
			room[i] = num;
			sum += num;
		}
		if (sum < S)
			ans = 0;
		else {
			int l = 0, r = 0;
			tmp = room[0];
			ans = (int) 1e9;
			while (l <= r && r < N) {

				if (tmp < S) {
					// 합이 S보다 적다면 쿨하게 더해준다.
					tmp += room[++r];
				} else if (tmp == S) {
					// 같으면 구간을 계산해본다.
					int len = (r - l) + 1;
					if (ans > len) {
						ans = len;
					}
					tmp += room[++r];
				} else {
					// 크다면 왼쪽에서 빼준다.
					int len = (r - l) + 1;
					if (ans > len) {
						ans = len;
					}
					tmp -= room[l++];
				}
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