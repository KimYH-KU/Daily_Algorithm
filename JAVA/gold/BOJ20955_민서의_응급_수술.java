import java.io.*;
import java.util.*;

public class BOJ20955_민서의_응급_수술 {
	
	/**
	 * 21.2.25
	 * 
	 * Union-find를 이용해서 풀이하였다. 다른 점이라고는 부모가 같을 때는 연결을 끊어야 하기 때문에 ++ 해준 점이 있다.
	 * 
	 * 그리고 union-find 이후에 부모 정리를 다시 해줬다. 여기가 살짝 헷갈려서.. 주말에 다시 봐봐야 겠다.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, parents[], ans;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			if (union(a, b)) { // 부모가 같다면 끊어야 한다.
				ans++;
			}
		}
		for (int i = 1; i <= N; i++) {
			int x = find(i);
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= N; i++) {
			//System.out.println("parents " + i + " " + parents[i]);
			if (!set.contains(parents[i]))
				set.add(parents[i]);
		}

		ans += (set.size() - 1);
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static boolean union(int a, int b) {
		int aP = find(a);
		int bP = find(b);
		if (aP == bP)
			return true;
		parents[aP] = bP;
		return false;
	}

	static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}