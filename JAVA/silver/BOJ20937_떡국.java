import java.io.*;
import java.util.*;

public class BOJ20937_떡국 {

	/**
	 * 21.3.10
	 * 
	 * 처음엔 순서를 유지해야 하는지 알고 잘못된 방법으로 생각했었다.
	 * 
	 * 가장 카운트가 많은 녀석보다 작아질 순 없다. 최대 그릇의 개수가 정답.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, room[], ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		room = new int[50001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = stoi(st.nextToken());
			room[num]++;
		}
		Arrays.sort(room);
		bw.append(String.valueOf(room[50000]));

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}