package racingcar.view;

import java.util.List;

public class OutputView {

	public static void printFirstResultsMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public static void printCurrentRacingResults(List<String> players, List<Integer> results) {
		for (int i = 0; i < players.size(); i++) {
			System.out.printf("%s : ", players.get(i));
			for(int j = 0 ; j < results.get(i); j ++){
				System.out.print('-');
			}
			System.out.println();
		}
	}

	public static void printFinalRacingResults(List<String> winners) {
		System.out.print("최종 우승자 : ");
		for(int i = 0 ; i < winners.size(); i ++){
			if(i != 0) System.out.print(", ");
			System.out.print(winners.get(i));
		}
	}
}
