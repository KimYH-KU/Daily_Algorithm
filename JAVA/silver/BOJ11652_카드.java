import java.io.*;
import java.util.*;

public class BOJ11652_카드 {

	/**
	 * 21.2.5
	 * 
	 * 자료형은 처음에 잘 파악해서 문제가 없었으나, 앞 수와 뒤 수가 다를 때, 개수와 상관없이 초기화 해줘야 한다는 것을 놓쳐서 자꾸 틀렸다.
	 * 
	 */
	
	static int N;
	static Long room[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		room = new Long[N];
		for (int i = 0; i < N; i++) {
			room[i] = stol(br.readLine());
		}
		Arrays.sort(room, Collections.reverseOrder());
		long ans = 0, num = 0;
		int cnt = 0;
		int _max = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				cnt++;
				num = room[i];
			} else {
				if (num == room[i]) {
					cnt++;
				} else {
					if (_max <= cnt) {
						_max = cnt;
						ans = room[i - 1];
					}
					num = room[i];
					cnt = 1;
				}
			}
		}
		if (_max <= cnt) {
			ans = room[N - 1];
		}
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();
	}

	static long stol(String s) {
		return Long.parseLong(s);
	}
}