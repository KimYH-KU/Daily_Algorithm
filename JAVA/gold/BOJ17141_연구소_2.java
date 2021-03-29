import java.io.*;
import java.util.*;

public class BOJ17141_연구소_2 {

	/**
	 * 21.3.29
	 * 
	 * 연구소 3을 풀었기 때문에 쉽게 풀 줄 알았으나 생각보다 시간이 걸렸다. BFS를 안해도 되는 조건에 주의.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, room[][], ans, canVirus, total;
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static boolean visited[][], virusVisited[];
	static Node[] nodeRoom;

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		room = new int[N][N];

		nodeRoom = new Node[11];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j] = stoi(st.nextToken());
				if (room[i][j] == 2) {
					nodeRoom[idx++] = new Node(i, j);
					total++;
				} else if (room[i][j] == 0) {
					total++; // 바이러스게 있게 해야 하는 곳++
				}
			}
		}
		canVirus = idx;
		virusVisited = new boolean[idx];
		ans = (int) 1e9;
		int[] tmp = new int[M];
		if (total != M)
			search(0, 0, tmp);
		else
			ans = 0;
		if (ans == (int) 1e9)
			ans = -1;
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static void search(int idx, int cnt, int[] tmp) {
		if (cnt == M) {
			// 어떤 곳에서 바이러스를 놓을 건지 결정 완료.
			// 놓은 곳에서 BFS 실행.
			bfs(tmp);
			return;
		}
		for (int i = idx; i < canVirus; i++) {
			if (!virusVisited[i]) {
				virusVisited[i] = true;
				tmp[cnt] = i;
				search(i + 1, cnt + 1, tmp);
				virusVisited[i] = false;
			}
		}
	}

	private static void bfs(int[] tmp) {
		visited = new boolean[N][N];
		int sum = 0;
		int time = 0;
		Queue<Node> q = new LinkedList<BOJ17141_연구소_2.Node>();
		for (int i = 0; i < M; i++) {
			Node node = nodeRoom[tmp[i]];
			q.add(node); // 시작점.
			visited[node.y][node.x] = true;
			sum++;
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				int y = node.y;
				int x = node.x;
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if (ny < 0 || nx < 0 || ny > N - 1 || nx > N - 1 || visited[ny][nx] || room[ny][nx] == 1)
						continue;
					visited[ny][nx] = true;
					q.add(new Node(ny, nx));
					sum++;
				}
			}
			time++;
			// 칸에 다 찼는지 확인.
			if (sum == total) {
				// 모든 빈 칸에 바이러스 가능.
				if (ans > time)
					ans = time;
				return;
			}
		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}