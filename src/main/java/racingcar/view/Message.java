package racingcar.view;

import java.util.List;

public class Message {
	public static void namingMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
	
	public static void roundingMessage() {
		System.out.println("시도할 회수는 몇회인가요?");
	}
	
	public static void resultMessage(List<String> winner, int winnerNumber) {
		System.out.print("최종 우승자 : ");
		for (int i=0; i<winnerNumber; i++) {
			System.out.print(winner.get(i) + ", ");
		}
	}
}