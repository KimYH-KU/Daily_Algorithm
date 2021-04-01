import java.io.*;
import java.util.*;

public class BOJ12871_무한_문자열 {

	/**
	 * 21.4.2
	 * 
	 * 처음에는 작은 길이의 문자열만 확인하면 풀 수 있을 줄 알았으나 ab, a 같은 경우 틀린다.
	 * 
	 * 그래서 최소공배수 길이만큼 만들어서 비교하면 정답.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int ans, gcd, lcm;
	static String S, T;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		S = br.readLine();
		T = br.readLine();
		int S_size = S.length();
		int T_size = T.length();
		int _min = Math.min(S_size, T_size);
		for (int i = 1; i <= _min; i++) {
			if (S_size % i == 0 && T_size % i == 0) {
				gcd = i;
			}
		}
		lcm = S_size * T_size / gcd;
		StringBuilder S_sb = new StringBuilder(), T_sb = new StringBuilder();
		int size = lcm / S_size;
		for (int i = 0; i < size; i++) {
			S_sb.append(S);
		}
		size = lcm / T_size;
		for (int i = 0; i < size; i++) {
			T_sb.append(T);
		}
		String s1, s2;
		s1 = S_sb.toString();
		s2 = T_sb.toString();
		if (s1.equals(s2))
			ans = 1;

		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}