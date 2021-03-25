import java.io.*;
import java.util.*;

public class BOJ17142_연구소_3 {

	/**
	 * 21.3.25
	 * 
	 * 끝까지 방심할 수가 없는 문제다. 기본적으로 조합 + BFS 유형의 삼성 문제였다.
	 * 
	 * 시간을 셀 때 조심해야 할 점이, 0이 하나도 없는 경우이다. 이 경우는 애초에 바이러스를 퍼트릴 필요가 없기 때문에
	 * 0으로 예외 처리를 해줘야 한다.
	 * 
	 * 그 이외에 활성이든 비활성이든 2는 바이러스가 놓인 자리로 인식한다는 점에 주의해서 풀면 된다.
	 * 
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

		// 2가 10 이하 이기 때문에 완탐으로 풀이 가능하다.
		// 최대 큰 수 -> 10C5 = 약 250
		// 최대 이동 -> 50^2 = 2500
		// 250 * 2500 -> 얼마 안됨.

		room = new int[N][N];

		nodeRoom = new Node[11];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j] = stoi(st.nextToken());
				if (room[i][j] == 2) {
					nodeRoom[idx++] = new Node(i, j);
				} else if (room[i][j] == 0)
					total++; // 바이러스게 있게 해야 하는 곳++
			}
		}
		canVirus = idx;
		virusVisited = new boolean[idx];
		ans = (int) 1e9;
		int[] tmp = new int[M];
		if (total != 0)
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
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			Node node = nodeRoom[tmp[i]];
			q.add(node); // 시작점.
			visited[node.y][node.x] = true;
		}

		while (!q.isEmpty()) {
			int size = q.size();
			// 1초마다 처리하기 위해서
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
					if (room[ny][nx] == 0) // 가려고 하는 쪽이 0 일때만 ++
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