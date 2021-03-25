import java.io.*;
import java.util.*;

public class BOJ2012_등수_매기기 {

	/**
	 * 21.3.26
	 * 
	 * 언제나 자료형에 주의하기. 500,000 까지가 입력이기 때문에 정답이 int형을 벗어날 수도 있다.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, room[];
	static long ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		room = new int[N];
		for (int i = 0; i < N; i++) {
			room[i] = stoi(br.readLine());
		}
		Arrays.sort(room);
		for (int i = 0; i < N; i++) {
			ans += Math.abs((i + 1) - room[i]);
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