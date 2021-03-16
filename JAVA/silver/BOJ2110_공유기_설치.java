import java.io.*;
import java.util.*;

public class BOJ2110_공유기_설치 {

	/**
	 * 21.3.16
	 * 
	 * 이분 탐색의 정석 문제 같다. 이분 탐색에서 내가 생각하는 포인트는 다음과 같다.
	 * 
	 * 1. 주어진 배열을 sorting 한다.
	 * 2. 시작과 끝을 잘 정한다.
	 * 3. while(s<=e) 를 돌면서, mid를 (s+e)/2로 설정한다.
	 * 4. 조건에 맞으면 s = mid+1, 아니면 e = mid-1로 설정한다.
	 * 5. e를 return한다. 생각해보면 e가 가능한 최댓값이다.
	 * 
	 */
	
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, C, room[], ans;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		C = stoi(st.nextToken());
		room = new int[N];
		for (int i = 0; i < N; i++) {
			room[i] = stoi(br.readLine());
		}
		Arrays.sort(room);
		ans = search(1, room[N - 1] - room[0]);
		bw.append(String.valueOf(ans));
		bw.flush();
		br.close();
		bw.close();

	}

	private static int search(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2; // 거리값
			if (check(mid)) {
				// 가능하면 거리를 더 키워본다.
				left = mid + 1;
			} else
				right = mid - 1; // 불가능이면 거리를 좁혀봄.
		}
		return right;
	}

	private static boolean check(int mid) {
		int cnt = 1;
		int _now = room[0];
		for (int i = 1; i < N; i++) {
			if (room[i] - _now >= mid) {
				cnt++;
				_now = room[i];
			}
		}
		if (cnt >= C) {
			return true;
		}
		return false;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}