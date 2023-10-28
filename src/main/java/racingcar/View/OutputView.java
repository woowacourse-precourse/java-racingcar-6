package racingcar.View;

import racingcar.Model.CarList;

public class OutputView {
	final static String GRAPH_UNIT = "-";
	final static String RESULT_MESSAGE = "실행 결과";
	final static String WINNER_MESSAGE = "최종 우승자";
	final static String MESSAGE_SEPARATOR = " : ";

	public static void printResult() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printEachRound(CarList carList) {

		for (int i = 0; i < carList.size(); i++) {
			System.out.println(carList.getEachCar(i) + MESSAGE_SEPARATOR + carList.getEachCar(i).makeDistanceGraph(GRAPH_UNIT));
		}

		System.out.println();
	}

	public static void printWinner(String winnerList) {
		System.out.println(WINNER_MESSAGE + MESSAGE_SEPARATOR + winnerList);
	}

}
