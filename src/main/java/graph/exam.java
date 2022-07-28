package graph;

import java.text.DecimalFormat;
import java.util.Scanner;

//회귀분석
public class exam {
	public static void main(String args[]) {

		final int START = 1813;
		final int END = 1859;
		double[] x = { 2, (float) 1.5, 10, 13, (float) 0.5, 3, 20, 28, 7, (float) 4.5 };
		double[] y = { 4000, 3000, 18000, 22000, 2000, 5500, 45000, 42000, 10000, 7000 };

		double result = 0;
		double distance = 0;
		double minDistance = 0;
		double best = 0;
		for (int a = START; a <= END; a += 1) {
			for (int i = 1; i < x.length; i++) {
				result = 0;
				// y값 계산
				result = a * x[i];
				// 차이 계산
				distance = Math.abs(y[i] - result);
			}
			System.out.println("y= " + a + "x 일 때 " + result + ", 점과 선 거리 : " + distance);

			// 차이의 합 계산
			if (a == START) {
				minDistance = distance;
				best = a;
			} else {
				if (minDistance > distance) {
					minDistance = distance;
					best = a;
				}
			}
		}

		// 최적의 a값, 차이의 합 찾기!!
		System.out.println("최적의 값 : " + best + " 차이의 합 : " + minDistance);
		// 사용자로부터 값 입력받기
		Scanner sc = new Scanner(System.in);
		//금액에 콤마찍기
		DecimalFormat formatter = new DecimalFormat("###,###");
		System.out.println("몇 킬로 요금을 알고싶으셔요?");
		double input = sc.nextDouble();
		double resultFee = best * input;
		int integerResultFee = (int) Math.round(resultFee);
		System.out.println(input + "km 이동하시면 " + formatter.format(integerResultFee) + "원 예측되셔요.");
	}
}

