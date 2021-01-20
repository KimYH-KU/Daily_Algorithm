import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린_괄호 {

	/**
	 * 2021.01.21
	 * 
	 * 어떻게 하면 최소 값을 구할 수 있는지 생각해야 되는 문제 였다.
	 * 
	 * -을 항상 최대 값으로 하면, 최소 값을 구할 수 있다. 그러기 위해서 +을 우선적으로 수행해줘야 함.
	 * 
	 */

	static int N, ans;
	static char room[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		room = new char[s.length()];
		room = s.toCharArray();

		int tmp = 0;
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = room[i];
			if (ch == '+') {
				sum += tmp;
				tmp = 0;
			} else if (ch == '-') {
				sum += tmp;
				list.add(sum);
				sum = 0;
				tmp = 0;
			} else {
				tmp *= 10;
				tmp += ch - '0';
			}
		}
		sum += tmp;
		list.add(sum);
		ans = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			ans -= list.get(i);
		}
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}