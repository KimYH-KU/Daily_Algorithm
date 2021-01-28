import java.io.*;
import java.util.*;

public class BOJ3048_개미 {

	/**
	 * 21.01.28 
	 * 
	 * 자바로 문자열 처리는 참 귀찮다... flag로 해서 왼쪽과 오른쪽 방향이 다를때만 순서를 바꿔 해결하였다.
	 * 
	 */
	
	static int N1, N2, T;
	static String S1, S2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N1 = stoi(st.nextToken());
		N2 = stoi(st.nextToken());
		S1 = br.readLine();
		S2 = br.readLine();
		T = stoi(br.readLine());
		StringBuilder sb = new StringBuilder();

		int size = S1.length() + S2.length();
		char room[] = new char[26];
		for (int i = 0; i < S1.length(); i++) {
			char tmp = S1.charAt(i);
			room[tmp - 'A'] = 1;
			sb.append(S1.charAt(S1.length() - 1 - i));
		}
		for (int i = 0; i < S2.length(); i++) {
			char tmp = S2.charAt(i);
			room[tmp - 'A'] = 2;
		}
		sb.append(S2);

		StringBuilder sb2 = new StringBuilder();
		sb2 = sb;
		for (int i = 0; i < T; i++) {
			sb2 = new StringBuilder();
			for (int j = 0; j < size; j++) {
				char ch = sb.charAt(j);
				if (j == size - 1) {
					sb2.append(ch);
					continue;
				}
				char ch2 = sb.charAt(j + 1);
				if (room[ch - 'A'] == 1 && room[ch2 - 'A'] == 2) {
					sb2.append(ch2).append(ch);
					j++;
				} else {
					sb2.append(ch);
				}
			}
			sb = sb2;
		}
		bw.append(sb2.toString());
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}