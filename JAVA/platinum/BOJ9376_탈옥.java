import java.io.*;
import java.util.*;

public class BOJ9376_탈옥 {
	
	/**
	 * 21.2.24
	 * 
	 * PS 실력이 늘었다고 생각했음에도 고전한 문제다.
	 * 
	 * 일단 이 문제는 아이디어 자체를 생각하기가 힘들다. 죄수 둘과 바깥에 임의의 한 점에서 BFS를 총 세 번 돌린다.
	 * 
	 * 그리고 나서 문을 연 횟수를 각각 저장한 다음에 더해야 하는데, 그 지점이 문 일 경우는 -2 해준다.
	 * 
	 * 아이디어를 생각하는게 매우 힘드며, Deque을 사용해야 쉽게 구현이 가능하다. 가지 못하는 곳은 답에서 제외해야 함에 주의하기.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int T, H, W, ans, roomCnt[][][];
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, -1, 0, 1 };
	static char room[][];
	static boolean visited[][];

	static class Node {
		int y, x, flag;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = stoi(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			H = stoi(st.nextToken());
			W = stoi(st.nextToken());
			room = new char[H + 2][W + 2];
			roomCnt = new int[H + 2][W + 2][3];
			// 입력
			Node[] waitRoom = new Node[3];
			int idx = 0;
			for (int i = 1; i <= H; i++) {
				String s = br.readLine();
				for (int j = 1; j <= W; j++) {
					room[i][j] = s.charAt(j - 1);
					if (room[i][j] == '$') {
						waitRoom[idx++] = new Node(i, j);
					}
				}
			}
			waitRoom[2] = new Node(0, 0);
			for (int i = 0; i < 3; i++) {
				search(waitRoom[i], i);
			}
			ans = calc();
			bw.append(String.valueOf(ans)).append('\n');
		}

		bw.flush();
		br.close();
		bw.close();

	}

	static int calc() {
		int min = (int) 1e9;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (room[i][j] == '*')
					continue;
				int tmp = 0;
				for (int k = 0; k < 3; k++) {
					tmp += roomCnt[i][j][k];
				}
				if (!visited[i][j])
					continue;
				if (room[i][j] == '#')
					tmp -= 2;
				if (min > tmp)
					min = tmp;
			}
		}
		return min;

	}

	static void search(Node startNode, int num) {

		// bfs 돌려줄 곳.
		// 다만, 문이 아니면 계속 전진이다. 이래야 문을 열 때 최소 횟수임을 보장할 수 있음.

		Deque<Node> dq = new ArrayDeque<BOJ9376_탈옥.Node>();
		dq.offer(startNode);
		visited = new boolean[H + 2][W + 2];
		visited[startNode.y][startNode.x] = true;
		while (!dq.isEmpty()) {
			Node node = dq.pollFirst();
			int y = node.y;
			int x = node.x;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny > H + 1 || nx > W + 1 || visited[ny][nx] || room[ny][nx] == '*')
					continue;
				visited[ny][nx] = true;
				// 문
				if (room[ny][nx] == '#') {
					roomCnt[ny][nx][num] = roomCnt[y][x][num] + 1;
					dq.offerLast(new Node(ny, nx));
				} else {
					roomCnt[ny][nx][num] = roomCnt[y][x][num];
					dq.offerFirst(new Node(ny, nx));
				}
			}
		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}