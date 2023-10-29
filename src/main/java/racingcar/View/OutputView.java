package racingcar.View;

import java.util.List;

import racingcar.Model.Car;

public class OutputView {
	final static String GRAPH_UNIT = "-";
	final static String RESULT_MESSAGE = "실행 결과";
	final static String WINNER_MESSAGE = "최종 우승자";
	final static String MESSAGE_SEPARATOR = " : ";

	public static void printResult() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printEachRound(List<Car> carList) {

		for (Car eachCar : carList) {
			System.out.println(eachCar.checkStatus(GRAPH_UNIT));
		}

		System.out.println();
	}

	public static void printWinner(String winnerList) {
		System.out.println(WINNER_MESSAGE + MESSAGE_SEPARATOR + winnerList);
	}

}
