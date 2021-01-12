import java.io.*;
import java.util.*;

public class BOJ20311_화학_실험 {
	
	/**
	 * 2021.01.12
	 * 
	 * 요세푸스 관련 문제에서 수를 채워넣을 때, O(n^2)으로 풀이를 한 적이 있다.
	 * 이 문제의 경우는 홀,짝 인덱스만 왔다 갔다 해서 시간을 줄였지만, 해당 문제 다시 복습해서 로직 알아두기.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, ans[];
	static Node[] room;

	static class Node implements Comparable<Node> {
		int i, num;

		public Node(int i, int num) {
			this.i = i;
			this.num = num;
		}

		public int compareTo(Node o) {
			return o.num - this.num;
		}

	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		room = new Node[K];
		ans = new int[N];
		int _max = 0;
		for (int i = 0; i < K; i++) {
			int tmp = stoi(st.nextToken());
			room[i] = new Node(i, tmp);
			if (_max < tmp)
				_max = tmp;
		}
		boolean flag = true;
		if (N % 2 == 0 && _max > N / 2)
			flag = false;
		else if (N % 2 == 1 && _max > N / 2 + 1)
			flag = false;
		else {
			Arrays.sort(room);
			int idx = 0;
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < room[i].num; j++) {
					ans[idx] = room[i].i + 1;
					idx += 2;
					if (idx >= N) {
						idx %= N;
						if (N % 2 == 0)
							idx++;
					}
				}
			}
		}
		if (!flag)
			bw.append(String.valueOf(-1));
		else {
			for (int i = 0; i < N; i++) {
				bw.append(String.valueOf(ans[i]) + ' ');
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}