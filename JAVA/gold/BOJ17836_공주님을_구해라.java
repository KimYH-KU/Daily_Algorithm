import java.io.*;
import java.util.*;

public class BOJ17836_공주님을_구해라 {
	
	/**
	 * bfs를 이용해 풀이 중, 사용하고 있는 변수의 값을 함부로 바꾸지 않도록 주의하기.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, T, ans;
	static int room[][];
	static boolean visited[][][];
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, -1, 0, 1 };

	static class Node {
		int y, x, flag;

		public Node(int y, int x, int flag) {
			this.y = y;
			this.x = x;
			this.flag = flag;
		}
	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		T = stoi(st.nextToken());
		room = new int[N][M];
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				room[i][j] = stoi(st.nextToken());
			}
		}
		visited = new boolean[N][M][2];
		ans = bfs(0, 0);
		if (ans == -1)
			bw.append("Fail");
		else
			bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static int bfs(int sy, int sx) {
		visited[sy][sx][0] = true;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(sy, sx, 0));
		int time = -1;
		while (!q.isEmpty()) {
			int size = q.size(); // 초마다 돌기 위해서
			time++;
			if (time > T)
				return -1;
			while (size-- > 0) {
				Node node = q.poll();
				int y = node.y;
				int x = node.x;
				int flag = node.flag;
				if (y == N - 1 && x == M - 1) {
					return time;
				}
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1 || visited[ny][nx][flag])
						continue;
					if (flag == 0) { // 검을 먹기 전.
						if (room[ny][nx] == 1)
							continue;
						if (room[ny][nx] == 2) {							
							visited[ny][nx][1] = true;
							q.offer(new Node(ny, nx, 1));
						}else {
							visited[ny][nx][0] = true;
							q.offer(new Node(ny, nx, 0));							
						}
					} else { // 검을 먹은 후.
						visited[ny][nx][flag] = true;
						q.offer(new Node(ny, nx, flag));
					}

				}
			}
		}
		return -1; // 탈출 못함.
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}