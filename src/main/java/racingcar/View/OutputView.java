package racingcar.View;

import java.util.List;

import racingcar.Model.Car;
import racingcar.Model.CarList;

public class OutputView {
	final static String GRAPH_UNIT = "-";
	final static String RESULT_MESSAGE = "실행 결과";
	final static String WINNER_MESSAGE = "최종 우승자 : ";

	public static void printResult() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printEachRound(CarList carList) {

		for(int i = 0; i < carList.size(); i++) {

			System.out.println(carList.getEachCar(i) + " : " + carList.getEachCar(i).makeDistanceGraph(GRAPH_UNIT));

		}

		System.out.println();

	}

	public static void printWinner(List<Car> winnerList) {
		System.out.println(WINNER_MESSAGE + winnerList);
	}
}
