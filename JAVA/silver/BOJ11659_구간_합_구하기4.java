import java.io.*;
import java.util.*;

public class BOJ11659_구간_합_구하기4 {

	/**
	 * 21.2.2
	 * 
	 * 구간합을 구할 때는 앞에서부터 합을 구한 뒤 sum[a]-sum[b] 꼴로 처리한다.
	 * 
	 */
	
	
	static int N, M, room[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		room = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int tmp = stoi(st.nextToken());
			if (i == 1)
				room[i] = tmp;
			else
				room[i] = room[i - 1] + tmp;
		}
		for (int i = 0; i < M; i++) {
			int a, b;
			st = new StringTokenizer(br.readLine());
			a = stoi(st.nextToken()) - 1;
			b = stoi(st.nextToken());
			bw.append(String.valueOf(room[b] - room[a]) + '\n');
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}