import java.io.*;
import java.util.*;

public class BOJ18442_우체국_1 {
	
	/**
	 * 21.3.8
	 * 
	 * 자료형에 주의해줘야 하는 문제였다. L이 10^12이기 때문에 long 자료형으로 처리해야 한다.
	 * 
	 * V, P가 20이하이기 때문에 완탐으로 해결 가능하다.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int V, P;
	static long L, ans, room[], ansPlace[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		V = stoi(st.nextToken());
		P = stoi(st.nextToken());
		L = Long.parseLong(st.nextToken());
		ans = (long) 1e14;
		st = new StringTokenizer(br.readLine());
		// v와 p가 20이하 이기 때문에, 가장 클 때인 20c10을 계산해 보더라도 20만이 안되므로 완탐 사용
		room = new long[V];
		visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			room[i] = Long.parseLong(st.nextToken());
		}
		search(0, 0);
		bw.append(String.valueOf(ans)).append('\n');
		for (int i = 0; i < P; i++) {
			bw.append(String.valueOf(ansPlace[i])).append(' ');
		}
		bw.flush();
		br.close();
		bw.close();

	}

	static void search(int cnt, int idx) {
		if (cnt == P) {
			long place[] = new long[P];
			int tmpIdx = 0;
			for (int i = 0; i < V; i++) {
				if (visited[i]) {
					place[tmpIdx++] = room[i];
				}
			}
			long sum = 0;
			for (int i = 0; i < V; i++) {
				long length = (long) 1e13;
				for (int j = 0; j < P; j++) {
					long tmpLength = Math.min(Math.abs(place[j] - room[i]), L - Math.abs(place[j] - room[i]));
					if (length > tmpLength)
						length = tmpLength;
				}
				sum += length;
			}
			if (ans > sum) {
				ans = sum;
				ansPlace = place;
			}
			return;
		}
		for (int i = idx; i < V; i++) {
			visited[i] = true;
			search(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}