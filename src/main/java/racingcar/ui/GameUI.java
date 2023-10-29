package racingcar.ui;

import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class GameUI {

	private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_REPEAT = "시도할 회수는 몇회인가요?";
	private static final String RESULT_WINNER = "최종 우승자 : %s";
	private static final String CAR_NAME_AND_POSITION = "%s : %s\n";

	public String[] inputCarNames() {
		System.out.println(INPUT_CAR_NAMES);
		return Console.readLine().split(",");
	}

	public int inputRepeat() {
		System.out.println(INPUT_REPEAT);
		return Integer.parseInt(Console.readLine());
	}

	public void printResult(List<String> winnerName) {
		System.out.printf(RESULT_WINNER, String.join(",", winnerName));
	}

	public void printHistory(Map<String, StringBuilder> movingHistory) {
		movingHistory.forEach((carName, history) -> System.out.printf(CAR_NAME_AND_POSITION, carName, history));
	}

	public void enter() {
		System.out.println();
	}
}
