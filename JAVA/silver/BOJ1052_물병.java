import java.io.*;
import java.util.*;

public class BOJ1052_물병 {
	
	/**
	 * 21.3.9
	 * 
	 * 이진법으로 풀어야 함을 알았는데, 효율적으로 풀진 못했다.
	 * 
	 * 수를 이진법으로 생각해보면, 111111(2)일 때, 1을 더해서 물병을 단 하나만 쓸 수 있음을 알 수 있다.
	 * 
	 * 이를 이용해서 1이 있는 자리면 그 만큼의 물을 더해줬는데(2의 n승 형태로 맞추기 위해서), 여기서 더해줄 때마다 나눗셈 연산을 다시 해줬다.
	 * 
	 * 잘 푼 사람의 로직을 꼭 찾아보기.
	 * 
	 */
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());

		int copyN = N;
		int nowCnt = 0;
		while (copyN > 0) {
			if (copyN % 2 == 1) {
				nowCnt++;
			}
			copyN /= 2;
		}
		// N이 2^t 인지 구함.
		// bw.append(String.valueOf(nowCnt));

		// 오른쪽 비트부터 봤을때, 다음 단계로 넘어가기 위해서는 비어있는 곳을 채워줘야 한다.
		if (nowCnt <= K)
			bw.append('0');
		else {
			int idx = 0;
			while (true) {
				copyN = N;
				nowCnt = 0;
				while (copyN > 0) {
					if (copyN % 2 == 1) {
						nowCnt++;
					}
					copyN /= 2;
				}
				if (nowCnt <= K)
					break;
				copyN = N;
				if ((1 & (copyN >> idx)) == 1) {
					ans += (1 << idx);
					N += (1 << idx);
				}
				idx++;
			}
			bw.append(String.valueOf(ans));
		}

		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}