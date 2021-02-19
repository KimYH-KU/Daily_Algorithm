import java.io.*;
import java.util.*;

public class BOJ10211_Maximum_Subarray {
	
	/**
	 * 21.2.20
	 * 
	 * 구간합을 구할 때 보통 합배열을 구해놓고 푸는데, 인덱스를 하나 더 주면 계산이 무척 편하다.
	 * 
	 * 가령 전체의 구간합을 생각할 경우 sum[N]-sum[0] 꼴이 되므로 구현하기도 편리하다.
	 * 
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int T, N, room[], _sum[], ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = stoi(br.readLine());
		while (T-- > 0) {
			N = stoi(br.readLine());
			st = new StringTokenizer(br.readLine());
			room = new int[N];
			_sum = new int[N + 1];
			for (int i = 0; i < N; i++) {
				room[i] = stoi(st.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				_sum[i] = _sum[i - 1] + room[i - 1];
			}
			ans = -(int) 1e9;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					int tmp = _sum[j] - _sum[i];
					if (tmp > ans)
						ans = tmp;
				}
			}
			bw.append(String.valueOf(ans) + '\n');
		}
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}