import java.io.*;
import java.util.*;

public class BOJ11399_ATM {

	/**
	 * 21.3.30
	 * 
	 * 가장 적은 시간이 가장 많이 더해져야 가장 최소의 값을 구할 수 있다.
	 * 
	 */
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, room[], sum[], ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		room = new int[N];
		sum = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = stoi(st.nextToken());
		}
		Arrays.sort(room);
		sum[0] = room[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + room[i];
		}
		for (int i = 0; i < N; i++) {
			ans += sum[i];
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