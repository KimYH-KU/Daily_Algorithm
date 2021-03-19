import java.io.*;
import java.util.*;

public class BOJ16198_에너지_모으기 {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, room[], ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		room = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = stoi(st.nextToken());
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(room[i]);
		}
		search(list, 0);
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	static void search(List<Integer> list, int _sum) {
		if (list.size() == 2) {
			if (ans < _sum)
				ans = _sum;
			return;
		}
		for (int i = 1; i < list.size() - 1; i++) {
			int tmp = list.get(i - 1) * list.get(i + 1);
			List<Integer> copyList = new ArrayList<Integer>();
			for (int j = 0; j < list.size(); j++) {
				if (i == j)
					continue;
				copyList.add(list.get(j));
			}
			search(copyList, _sum + tmp);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}