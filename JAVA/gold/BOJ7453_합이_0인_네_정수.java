import java.io.*;
import java.util.*;

public class BOJ7453_합이_0인_네_정수 {

	/**
	 * 2021.01.18
	 * 
	 * 며칠 전에 대회에서 비슷한 문제가 나와서 풀어보았다.
	 * 
	 * 그 때만 해도, 네 개의 배열을 두개로 줄인 뒤 두 개의 배열을 투 포인터나 이분 탐색을 이용해서 풀어야 겠다고 생각했지만,
	 * 결국 풀지 못했고 두 가지 풀이가 다 가능한 것을 이후 리뷰를 통해 알게 되었다.
	 * 
	 * 둘 모두를 완벽하게 사용하지 못하고 있단 생각이 들었다.
	 * 
	 * lower_bound나 upper_bound의 경우에는 모두 end를 return하며, 둘다 찾는 값이 나왔을 때 바로 종료하는 이분탐색과 달리
	 * lower_bound는 원하는 값 이상의 값이 처음 나오는 위치, upper_bound는 원하는 값을 초과하는 값이 처음 나오는 위치를 항상 명심.
	 * 
	 * 투 포인터 같은 경우에도 저런 for문을 통해 코드를 짤 수 있다.
	 * 
	 */
	
	static int N;
	static int[] A, B, C, D, AA, BB;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		AA = new int[N * N];
		BB = new int[N * N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = stoi(st.nextToken());
			B[i] = stoi(st.nextToken());
			C[i] = stoi(st.nextToken());
			D[i] = stoi(st.nextToken());
		}
		int cnt = 0;
		int left, right;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AA[cnt] = A[i] + B[j];
				BB[cnt++] = C[i] + D[j];
			}
		}
		left = right = N * N - 1;
		Arrays.sort(AA);
		Arrays.sort(BB);
		for (int i = 0; i <= left && right >= 0;) {
			int a = AA[i];
			int b = BB[right];
			int leftCnt, rightCnt, sum;
			leftCnt = rightCnt = 0;
			sum = a + b;
			if (sum == 0) {
				while (i <= left && a == AA[i]) {
					i++;
					leftCnt++;
				}
				while (right >= 0 && b == BB[right]) {
					right--;
					rightCnt++;
				}
				ans += (long) leftCnt * (long) rightCnt;
			} else if (sum > 0) {
				right--;

			} else {
				i++;
			}
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