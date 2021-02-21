import java.io.*;
import java.util.*;

public class BOJ1676_팩토리얼_0의_개수 {
	
	/**
	 * 21.02.22
	 * 
	 * 처음엔 2,5,10을 다 따로따로 생각하려 했는데 생각해보니 어차피 10도 2*5이기 때문에 다 같이 생각해줬다.
	 * 
	 * 2의 빈도보다 5의 빈도가 더 적기 때문에 5의 개수만 세서 문제를 해결하였다.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (i % 5 == 0) {
				ans++;
				int num = i;
				while (true) {
					num /= 5;
					if (num % 5 != 0)
						break;
					ans++;
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