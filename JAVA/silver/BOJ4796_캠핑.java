import java.io.*;
import java.util.*;

public class BOJ4796_캠핑 {

	/**
	 * 21.3.15
	 * 
	 * 제한이 있기 때문에 앞에서 부터 그 제한을 쓰면 결국 /, % 으로 해결 가능하다.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int L, P, V, idx;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			st = new StringTokenizer(br.readLine());
			L = stoi(st.nextToken());
			P = stoi(st.nextToken());
			V = stoi(st.nextToken());
			if (L + P + V == 0)
				break;
			// P일중 L만 사용 가능.
			int num = V / P;
			int mod = V % P;
			int _min = Math.min(mod, L);
			bw.append("Case ").append(String.valueOf(++idx)).append(": ").append(String.valueOf(num * L + _min))
					.append('\n');
		}

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}