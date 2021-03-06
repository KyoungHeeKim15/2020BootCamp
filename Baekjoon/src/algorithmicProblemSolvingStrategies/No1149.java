package algorithmicProblemSolvingStrategies;

import java.util.Arrays;
import java.util.Scanner;

public class No1149 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] rgb = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int i = 0; i< N; i++) {
			Arrays.fill(dp[i], 0);
			rgb[i][0] = scan.nextInt();
			rgb[i][1] = scan.nextInt();
			rgb[i][2] = scan.nextInt();
		}
		scan.close();
		
		for(int i = 0; i < 3; i++) dp[0][i] = rgb[0][i];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
			}
		}
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		System.out.println(min);
	}

}
