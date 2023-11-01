package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

	public String carNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		return Console.readLine();
	}
	public int rounds() {
		System.out.println(INPUT_ROUND_MESSAGE);
		return Integer.parseInt(Console.readLine());
	}
}
