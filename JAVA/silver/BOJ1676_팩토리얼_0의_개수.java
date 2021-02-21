import java.io.*;
import java.util.*;

public class BOJ1676_팩토리얼_0의_개수 {
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