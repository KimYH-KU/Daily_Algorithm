import java.io.*;
import java.util.*;

public class BOJ9655_돌_게임 {

	/**
	 * 21.01.29
	 * 
	 * 돌 게임을 왜 하는 걸까? 홀수와 짝수가 왔다갔다하는 문제이다.
	 * 
	 */
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = stoi(br.readLine());
		if(N % 2 == 1)
			bw.append("SK");
		else
			bw.append("CY");

		
		bw.flush();
		br.close();
		bw.close();

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}