import java.io.*;
import java.util.*;

public class BOJ1744_수_묶기 {

	/**
	 * 21.2.23
	 * 
	 * 신박한 문제였다. 문제에서 필요한 건 수를 어떻게 분리하냐는 거였는데, 총 네 가지 조건이 필요하다.
	 * 
	 * 우선 0은 분리해뒀다가 음수인 수가 남을 때 사용할 수 있다.
	 * 
	 * 그리고 1은 무조건 따로 더해주는 것이 유리하다. (1,2)생각.
	 * 
	 * 나머지 양수랑 음수는 짝을 맞추어서 절대값이 큰 순서대로 정렬해서 계산해주면 된다.
	 */

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, ans;
	static boolean zeroFlag;
	static List<Integer> minusList, plusList;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = stoi(br.readLine());
		minusList = new ArrayList<Integer>();
		plusList = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int num = stoi(br.readLine());
			if (num == 0) {
				zeroFlag = true;
			} else if (num < 0) {
				minusList.add(num);
			} else
				plusList.add(num);
		}

		Collections.sort(plusList, Collections.reverseOrder());
		Collections.sort(minusList);
		int saveNum = 0;
		for (int num : plusList) {
			if (saveNum == 0) {
				saveNum = num;
			} else {
				ans += saveNum * num;
				saveNum = 0;
			}
		}
		if (saveNum != 0)
			ans += saveNum;

		saveNum = 0;

		for (int num : minusList) {
			if (saveNum == 0) {
				saveNum = num;
			} else {
				ans += saveNum * num;
				saveNum = 0;
			}
		}
		if (saveNum != 0 && !zeroFlag) {
			ans += saveNum;
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