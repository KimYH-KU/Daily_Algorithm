import java.io.*;
import java.util.*;

public class BOJ18223_민준이와_마산_그리고_건우 {

	/**
	 * 21.01.25
	 * 
	 * 다익스트라 사용 시에 항상 dist 배열 초기화에 주의하기. 
	 * 그리고 중간 지점이 포함되어 있는지 알기 위해서는 다익스트라를 중간지점에서 한 번 더 수행해보면 된다.
	 */
	
	static int V, E, P;
	static List<Node> list[];
	static int dist[], ans;

	static class Node implements Comparable<Node> {
		int v, cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = stoi(st.nextToken());
		E = stoi(st.nextToken());
		P = stoi(st.nextToken());
		list = new ArrayList[V + 1];
		dist = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
			dist[i] = (int) 1e9;
		}
		int f, t, c;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			f = stoi(st.nextToken());
			t = stoi(st.nextToken());
			c = stoi(st.nextToken());
			list[f].add(new Node(t, c));
			list[t].add(new Node(f, c));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0)); // 출발~
		dist[1] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int v = node.v;
			int cost = node.cost;

			for (Node next : list[v]) {
				if (dist[next.v] > cost + next.cost) {
					dist[next.v] = cost + next.cost;
					pq.offer(new Node(next.v, cost + next.cost));
				}
			}
		}

		ans = dist[V];
		int tmp = dist[P]; // 중간 지점.
		for (int i = 0; i <= V; i++)
			dist[i] = (int) 1e9;
		dist[P] = 0;
		pq = new PriorityQueue<>();
		pq.offer(new Node(P, 0)); // 중간 지점에서 출발.
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int v = node.v;
			int cost = node.cost;
			if (v == V)
				break;
			for (Node next : list[v]) {
				if (dist[next.v] > cost + next.cost) {
					dist[next.v] = cost + next.cost;
					pq.offer(new Node(next.v, cost + next.cost));
				}
			}
		}
		if (ans == tmp + dist[V])
			bw.append("SAVE HIM");
		else
			bw.append("GOOD BYE");
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}