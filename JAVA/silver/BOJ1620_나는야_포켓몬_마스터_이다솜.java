import java.io.*;
import java.util.*;

public class BOJ1620_나는야_포켓몬_마스터_이다솜 {

	/**
	 * 21.3.4
	 * 
	 * Map을 사용했다. N이 십만 이하고, 포켓몬 이름이 알파벳이기 때문에 편하게 하기 위해 거꾸로도 map에 넣어주었다.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map.put(s, String.valueOf(i + 1));
			map.put(String.valueOf(i + 1), s);
		}

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			bw.append(map.get(s)).append('\n');
		}

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}