import java.io.*;
import java.util.*;

public class BOJ20312_CPU_벤치마킹 {

	/**
	 * 2021.01.13
	 * 
	 * (A*B)에 대해서 mod 연산 시에는 ((A mod m) * (B mod m)) mod m 임에 유의하기.
	 * 
	 */
	
	static long ans, room[], sum[];
	static int mod = (int) (1e9+7);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = stoi(br.readLine());
		room = new long[N];
		sum = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			room[i] = stoi(st.nextToken());
		}
		ans = room[0];
		sum[0] = room[0];
		for (int i = 1; i < N - 1; i++) {
			sum[i] = ((room[i] % mod * sum[i - 1] % mod) % mod + room[i]) % mod;

			ans = (ans + sum[i]) % mod;
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