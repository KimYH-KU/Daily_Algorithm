import java.io.*;
import java.util.*;

public class BOJ19542_전단지_돌리기 {

	/**
	 * 21.4.1
	 * 
	 * 아이디어를 생각하기 어려운 문제였다. 깊이를 어떻게 하면 알 지 고민하다가 리프노드에서 부터 재귀를 통해 확인을 해야 됨을 파악했다.
	 * 
	 * 단 이 문제 같은 경우, Math.max()를 통해 계속 최댓값으로 depth를 갱신해줘야 한다.
	 * 
	 * 이 후, BFS를 돌리면서 주어진 D를 참고해 BFS를 돌고 나서 돌아가야 하기 때문에 그 합의 *2를 하면 정답.
	 */

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, S, D, ans;
	static boolean visited[];
	static List<Integer> list[];
	static int room[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		S = stoi(st.nextToken());
		D = stoi(st.nextToken());
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		room = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		dfs(S);
		bfs();
		bw.append(String.valueOf(ans * 2));
		bw.flush();
		br.close();
		bw.close();

	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		visited = new boolean[N + 1];
		visited[S] = true;
		while (!q.isEmpty()) {
			int start = q.poll();
			for (int num : list[start]) {
				if (!visited[num] && room[num] >= D) {
					visited[num] = true;
					q.add(num);
					ans++;
				}
			}
		}
	}

	private static int dfs(int num) {
		// S에서 시작.
		boolean check = true;
		int depth = 0;
		visited[num] = true;
		for (int start : list[num]) {
			if (!visited[start]) {
				check = false;
				depth = Math.max(depth, dfs(start) + 1);
			}
		}
		if (!check) { // 리프 노드가 아니면,
			room[num] = depth;
		}
		return depth;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}