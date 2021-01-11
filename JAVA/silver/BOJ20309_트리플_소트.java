import java.io.*;
import java.util.*;

public class BOJ20309_트리플_소트 {
	
	/**
	 * 2021.01.11
	 * 
	 * 어떤 로직으로 풀어야 할 지 생각이 안나서 N이 3,4,5 일 때를 적어서 가능한 경우의 수를 생각해 보았다.
	 * 
	 * 트리플 소트라는 말은 가운데에 있는 수를 기준으로 1번과 3번이 위치가 바뀌기 때문에 홀수 인덱스가 짝수 인덱스로 되는 일이 없어서 이를 이용해 풀이하였다.
	 * 
	 */
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			int num = stoi(st.nextToken());
			if (i % 2 == 0) {
				// 홀수 번째 일때
				if (num % 2 == 0) {
					flag = false;
					break;
				}
			} else {
				if (num % 2 == 1) {
					flag = false;
					break;
				}
			}
		}
		if (flag)
			bw.append("YES");
		else
			bw.append("NO");
		bw.flush();
		br.close();
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}