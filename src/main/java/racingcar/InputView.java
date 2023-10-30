package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public String askCarName() {
		final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
		System.out.println(INPUT_MESSAGE);

		return Console.readLine();
	}

	public String askTryCount() {
		final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
		System.out.println(INPUT_MESSAGE);

		return Console.readLine();
	}
}
