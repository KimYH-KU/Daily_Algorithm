import java.io.*;
import java.util.*;

public class BOJ20949_효정과_새_모니터 {
	
	/**
	 * 21.2.26
	 * 
	 * 클래스를 선언해주고, sort 방식을 지정해 준 후 정렬한 뒤 idx만을 출력한다.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, W, H;

	static class Node implements Comparable<Node> {

		int w, h, idx;

		public Node(int w, int h, int idx) {
			this.w = w;
			this.h = h;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {
			if (this.w * this.w + this.h * this.h == o.w * o.w + o.h * o.h)
				return this.idx - o.idx;
			return (o.w * o.w + o.h * o.h) - (this.w * this.w + this.h * this.h);
		}

	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		List<Node> list = new ArrayList<BOJ20949_효정과_새_모니터.Node>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W = stoi(st.nextToken());
			H = stoi(st.nextToken());
			list.add(new Node(W, H, i + 1));
		}
		Collections.sort(list);
		for (Node node : list) {
			bw.append(String.valueOf(node.idx)).append('\n');
		}
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}