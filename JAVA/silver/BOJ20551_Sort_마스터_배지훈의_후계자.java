import java.io.*;
import java.util.*;

public class BOJ20551_Sort_마스터_배지훈의_후계자 {

	/**
	 * 2021.01.15
	 * 
	 * lowerbound, upperbound 꼭 정리하고 로직 이해하기. 직접 손으로 해봐야겠다
	 * 
	 */
	
	static int N, M, room[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		room = new int[N];
		for (int i = 0; i < N; i++) {
			int tmp = stoi(br.readLine());
			room[i] = tmp;
		}
		Arrays.sort(room);
		for (int i = 0; i < M; i++) {
			int tmp = stoi(br.readLine());
			int x = search(tmp, 0, N);
			bw.append(String.valueOf(x) + '\n');
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static int search(int tmp, int s, int e) {
		int _s, _e, _m;
		_s = s;
		_e = e;
		while (_s < _e) {
			_m = (_s + _e) / 2;
			if (room[_m] < tmp) {
				_s = _m + 1;
			} else {
				_e = _m;
			}
		}
		if (_e == N || room[_e] != tmp)
			return -1;
		return _e;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}