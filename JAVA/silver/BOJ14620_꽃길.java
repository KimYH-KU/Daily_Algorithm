import java.io.*;
import java.util.*;

public class BOJ14620_꽃길 {

	/**
	 * 21.3.22
	 * 
	 * 완탐으로 해결해야 하는 문제였다. 주어진 점이 겹치는지 확인하기 위해서 두 점 사이의 거리를 계산해서 해결했다.
	 * 
	 * 저 방법 말고도 집합을 이용해서 들어가는 점이 겹치지 않는지 집합의 크기로 확인하는 방법도 가능하다.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, room[][], sum[][], ans;
	static boolean visited[][];

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
		N = stoi(br.readLine());
		room = new int[N][N];
		sum = new int[N - 2][N - 2];
		visited = new boolean[N - 2][N - 2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j] = stoi(st.nextToken());
			}
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < N - 2; j++) {
				int ni = 1 + i;
				int nj = 1 + j;
				sum[i][j] = room[ni][nj] + room[ni][nj - 1] + room[ni - 1][nj] + room[ni + 1][nj] + room[ni][nj + 1];
			}
		}
		ans = (int) 1e9;
		// 겹치지 않게 sum 배열에서 3 점 골라주면 됨.
		Node tmp[] = new Node[3];
		search(0, 0, 0, tmp);
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static void search(int y, int x, int cnt, Node[] tmp) {
		if (cnt == 3) {
			if (check(tmp)) {
				int _sum = 0;
				for (int i = 0; i < 3; i++) {
					_sum += sum[tmp[i].y][tmp[i].x];
				}
				if (ans > _sum)
					ans = _sum;
			}
			return;
		}
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < N - 2; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					tmp[cnt] = new Node(i, j);
					search(i, j + 1, cnt + 1, tmp);
					visited[i][j] = false;
				}
			}
		}
	}

	private static boolean check(Node[] tmp) {
		// 세 점 사이의 간격 체크.
		for (int i = 0; i < 3; i++) {
			if ((Math.abs(tmp[i % 3].y - tmp[(i + 1) % 3].y) + Math.abs(tmp[i % 3].x - tmp[(i + 1) % 3].x)) <= 2)
				return false;
		}
		return true;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}