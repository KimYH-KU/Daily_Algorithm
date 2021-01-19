import java.io.*;
import java.util.*;

public class BOJ2877_4와_7 {

	/**
	 * 2021.01.20
	 * 
	 * 처음에 보고 수를 두 개 사용하기 때문에 2진수로 바로 접근하였다.
	 * 
	 * +1을 해서 문제를 푸는게 핵심이었다.
	 */
	
	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());

		StringBuilder sb = new StringBuilder();
		N++; // 원래 2진수 변환을 생각해보면, 2-> 10 으로 넘어가는데 얘는 7이라 +1 해줌.
		while (N > 0) {
			int num = N % 2;
			sb.append(num);
			N /= 2;

		}
		String s = sb.toString();
		for (int i = s.length() - 2; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == '0')
				bw.append(String.valueOf(4));
			else
				bw.append(String.valueOf(7));
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}