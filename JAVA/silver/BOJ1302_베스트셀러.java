import java.io.*;
import java.util.*;

public class BOJ1302_베스트셀러 {

	/**
	 * 21.4.5
	 * 
	 * Map에서 한 번에 value를 가져올 방법이 없다. keySet()을 돌면서 가져와야함.
	 * 
	 */
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				int num = map.get(s);
				map.put(s, num + 1);
			}
		}
		Set<String> set = map.keySet();
		List<Integer> list = new ArrayList<Integer>();
		for (String s : set) {
			int num = map.get(s);
			list.add(num);
		}
		Collections.sort(list, Collections.reverseOrder());
		int _max = list.get(0);
		List<String> room = new ArrayList<String>();
		for (String s : set) {
			int num = map.get(s);
			if (num == _max) {
				room.add(s);
			}
		}
		Collections.sort(room);
		bw.append(room.get(0));
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}