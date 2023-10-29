package racingcar.View;

import java.util.List;

import racingcar.Car;

public class OutputView {
	public static void printRoundStart(){
		System.out.println("\n실행 결과");
	}

	public static void printRoundResult(String carName, int forwardCount){
		StringBuilder result = new StringBuilder();

		result.append(carName).append(" : ");
		for (int i = 0; i < forwardCount; i++) {
			result.append("-");
		}
		System.out.println(result);
	}
	public static void printWinner(List<String> winners){
		String winnerList = String.join(", ", winners);
		System.out.println("최종 우승자 : " + winnerList);
	}
}
