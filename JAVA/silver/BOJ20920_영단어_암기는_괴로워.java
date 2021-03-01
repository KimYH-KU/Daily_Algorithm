import java.io.*;
import java.util.*;

public class BOJ20920_영단어_암기는_괴로워 {
	
	/**
	 * 21.3.1
	 * 
	 * 이런 류 문제로 나오기 좋은 문제가 아니었나 싶다. Map에서 값을 가져올 때는 아래처럼 keySet()을 통해 가져오기.
	 * 
	 * IDE가 있어서 풀 수 있었다. Map관련 메소드를 조금 알아둬야 할 듯. 같은 길이일 때 사전순으로 정렬하기 위해선 str1.compareTo(str2) 까먹지 말기.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M;

	static class Node implements Comparable<Node> {

		int cnt;
		String s;

		public Node(int cnt, String s) {
			this.cnt = cnt;
			this.s = s;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				if (o.s.length() == this.s.length())
					return this.s.compareTo(o.s);
				return o.s.length() - this.s.length();
			}
			return o.cnt - this.cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.length() < M)
				continue;
			if (map.containsKey(s)) {
				int num = map.get(s);
				map.replace(s, num + 1);
			} else {
				map.put(s, 1);
			}
		}
		List<Node> list = new ArrayList<BOJ20920_영단어_암기는_괴로워.Node>();
		Set<String> set = map.keySet();
		for (String str : set) {
			int tmp = map.get(str);
			list.add(new Node(tmp, str));
		}

		Collections.sort(list);
		for (Node node : list) {
			bw.append(node.s).append('\n');
		}

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}