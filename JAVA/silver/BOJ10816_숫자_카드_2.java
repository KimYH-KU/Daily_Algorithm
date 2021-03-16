import java.io.*;
import java.util.*;

public class BOJ10816_숫자_카드_2 {

	/**
	 * 21.3.17
	 * 
	 * upper_bound와 lower_bound 구현 잊지 말기. 
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, room[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		room = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = stoi(st.nextToken());
		}
		Arrays.sort(room);
		M = stoi(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = stoi(st.nextToken());
			int left = lower_search(num);
			int right = upper_search(num);
			bw.append(String.valueOf(right - left)).append(' ');
		}

		bw.flush();
		br.close();
		bw.close();

	}

	private static int upper_search(int num) {
		int s = 0;
		int e = N;
		while (s < e) {
			int m = (s + e) / 2;
			if (room[m] <= num) {
				s = m + 1;
			} else {
				e = m;
			}
		}
		return e;
	}

	private static int lower_search(int num) {
		int s = 0;
		int e = N;
		while (s < e) {
			int m = (s + e) / 2;
			if (room[m] < num) {
				s = m + 1;
			} else {
				e = m;
			}
		}
		return e;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}