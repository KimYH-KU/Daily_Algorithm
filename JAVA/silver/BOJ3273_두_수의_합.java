import java.io.*;
import java.util.*;

public class BOJ3273_두_수의_합 {
	
	/**
	 * 21.2.16
	 * 
	 * 투 포인터를 이용하였다. 투 포인트를 이용할 떄 for문을 증감식을 제외한 형태로 l,r을 움직이면 편하게 사용할 수 있다.
	 * 
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, room[], X, ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		room = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = stoi(st.nextToken());
		}
		X = stoi(br.readLine());
		Arrays.sort(room);
		int r = N - 1;
		for (int l = 0; l < N && r >= 0;) {
			int sum = room[l] + room[r];
			if (l == r)
				break;
			if (sum == X) {
				ans++;
				l++;
			} else if (sum < X) {
				l++;
			} else
				r--;
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