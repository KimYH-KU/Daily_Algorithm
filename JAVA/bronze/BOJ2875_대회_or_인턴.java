import java.io.*;
import java.util.*;

public class BOJ2875_대회_or_인턴 {

	/**
	 * 2021.01.19
	 * 
	 * 반복문에서 조건식 사용할 때 주의하기.
	 * 
	 */
	
	static int N, M, K, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		while (K > 0) {
			if (N / 2 < M) {
				M--;
				K--;
			} else {
				N--;
				K--;
			}
		}
		while (true) {
			N -= 2;
			M--;
			if (N < 0 || M < 0)
				break;
			ans++;
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