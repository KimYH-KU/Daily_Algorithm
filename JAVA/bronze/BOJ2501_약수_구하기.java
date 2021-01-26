import java.io.*;
import java.util.*;

public class BOJ2501_약수_구하기 {

	/**
	 * 21.01.26
	 * 
	 * 약수를 어떻게 구할까?? 브루트 포스로 풀이하였다.
	 * 
	 */
	
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				if (K == ++cnt) {
					bw.append(String.valueOf(i));
					break;
				}
			}
		}
		if (K > cnt)
			bw.append(String.valueOf(0));

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}