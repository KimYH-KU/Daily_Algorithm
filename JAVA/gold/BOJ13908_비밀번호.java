import java.io.*;
import java.util.*;

public class BOJ13908_비밀번호 {

	/**
	 * 21.2.8
	 * 
	 * 집합을 이용해 문제를 풀이하였다. 재귀와 백트래킹을 이용했는데, 어떤 수인지가 중요한게 아니라 써야하는 수를 모두 사용했는지를 확인하면 되는 문제였다. 
	 * 
	 * 
	 */
	
	static int N, M, ans;
	static Set<Integer> needSet;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		needSet = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = stoi(st.nextToken());
			needSet.add(tmp);
		}
		Set<Integer> set = new HashSet<Integer>();
		search(0, set);
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();
	}

	static void search(int cnt, Set<Integer> set) {
		if (cnt == N) {
			if (set.size() == needSet.size()) {
				ans++;
			}
			return;
		}
		if (needSet.size() - set.size() > N - cnt) {
			return;
		}
		for (int i = 0; i <= 9; i++) {
			boolean flag = false;
			if (needSet.contains(i) && !set.contains(i)) {
				set.add(i);
				flag = true;
			}
			search(cnt + 1, set);
			if (flag)
				set.remove(i);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}