import java.io.*;
import java.util.*;

public class BOJ1181_단어_정렬 {

	/**
	 * 21.01.27
	 * 
	 * 1. 익명클래스로 Comparator를 생성해서 정렬하기. 문자열은 사전 정렬할 때 s.compareTo(s2) 사용해야 함.
	 * 
	 * 2. 중복 제거할때 집합에 넣어두고, 이를 이용해 리스트를 만들면 편하다.
	 */
	
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = stoi(br.readLine());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		});
		for (String _s : list) {
			bw.append(_s + '\n');
		}
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}