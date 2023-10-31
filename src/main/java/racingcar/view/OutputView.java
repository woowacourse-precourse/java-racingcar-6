package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

	public static void printFirstMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public static void printCurrentRacingResults(List<String> players, List<Integer> results) {
		for (int i = 0; i < players.size(); i++) {
			System.out.printf("%s : ", players.get(i));
			IntStream.range(0, results.get(i))
					.map(j -> '-')
					.forEach(System.out::print);
			System.out.println();
		}
	}

	public static void printFinalRacingResults(List<String> winners) {
		System.out.print("최종 우승자 : ");
		for (int i = 0; i < winners.size(); i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(winners.get(i));
		}
	}
}
