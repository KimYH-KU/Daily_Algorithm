import java.io.*;
import java.util.*;

public class BOJ2217_로프 {
	
	/**
	 * 21.2.17
	 * 
	 * 그리디 문제, 중간에 else를 써서 앞에서 봤을 때 한 번 막히면 끝이라 생각했는데, 
	 * 
	 * 고만고만한 녀석들끼리는 더하는게 더 효율이 잘 나오는 경우가 있나보다.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		Integer room[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			room[i] = stoi(br.readLine());
		}
		Arrays.sort(room, Collections.reverseOrder());
		ans = room[0];
		int cnt = 1;
		int sum = room[0];
		for (int i = 1; i < N; i++) {
			sum += room[i];
			cnt++;
			if (room[i] * cnt < sum) {
				if (room[i] * cnt > ans)
					ans = room[i] * cnt;
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