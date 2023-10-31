package racingcar.view;

import java.util.List;

import racingcar.model.CarsService;

public class OutputView {
	final static String GRAPH_UNIT = "-";
	final static String RESULT_MESSAGE = "실행 결과";
	final static String WINNER_MESSAGE = "최종 우승자";
	final static String MESSAGE_SEPARATOR = " : ";

	public static void printResult() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public static void printEachRound(CarsService carsService) {

		List<String> graphs = carsService.makeGraphs(GRAPH_UNIT);

		for (String eachGraph : graphs) {
			System.out.println(eachGraph);
		}

		System.out.println();
	}

	public static void printWinner(String winner) {
		System.out.println(WINNER_MESSAGE + MESSAGE_SEPARATOR + winner);
	}

}
