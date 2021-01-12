import java.io.*;
import java.util.*;

public class BOJ20310_타노스 {
	
	/**
	 * 2021.01.12
	 * 
	 * 고민을 해 보다가 앞에서부터 1을 절반 제거해주고, 뒤에서부터 0을 절반 제거하는 방법으로 문제를 풀었다.
	 * 아이디어 필요한 문제 많이많이 풀어보기.
	 * 
	 */
	
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] room = br.readLine().toCharArray();
		int zeroCnt = 0, oneCnt = 0;
		int usedZeroCnt = 0, usedOneCnt = 0;
		for (int i = 0; i < room.length; i++) {
			if (room[i] == '0')
				zeroCnt++;
			else
				oneCnt++;
		}
		// 앞에서부터 1 제거하고, 뒤에서부터 0 제거
		for (int i = 0; i < room.length; i++) {
			if (room[i] == '1') {
				room[i] = '2';
				usedOneCnt++;
			}
			if (oneCnt / 2 == usedOneCnt)
				break;
		}
		for (int i = room.length - 1; i >= 0; i--) {
			if (room[i] == '0') {
				room[i] = '2';
				usedZeroCnt++;
			}
			if (zeroCnt / 2 == usedZeroCnt)
				break;
		}
		for (int i = 0; i < room.length; i++) {
			if (room[i] != '2')
				bw.append(room[i]);
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}