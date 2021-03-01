import java.io.*;
import java.util.*;

public class BOJ20921_그렇고_그런_사이 {
	
	/**
	 * 21.3.2
	 * 
	 *  순열과 관련된 문제라는 생각이 들었다.
	 *  예로, N개가 있을 때 첫 번째 수가 가장 크다면, N-1개가 만들어지고, 그 다음은 N-2,N-3,...,2,1 이런식이다.
	 *  처음엔 boolean으로 자리마다 체크해주면 될 줄 알았으나, 그냥 빼가면서 문제를 해결해주었다.
	 *  아닌 자리는 1부터 작은 값을 채워넣었다.
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, room[];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());

		room = new int[N];
		int useN = N;
		int reverseN = 1;
		for (int i = 1; i <= N; i++) {
			if (K >= N - i) {
				K -= (N - i);
				room[i - 1] = useN--;
			} else {
				room[i - 1] = reverseN++;
			}
		}

		for (int i = 0; i < N; i++) {
			bw.append(String.valueOf(room[i])).append(' ');
		}

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}