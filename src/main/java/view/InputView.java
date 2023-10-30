package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	
	private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TOTAL_MOVE_MESSAGE = "시도할 회수는 몇회인가요?";

	public String nameText() {
		System.out.println(INPUT_CAR_NAME_MESSAGE);
		return Console.readLine();
	}
	
	public String totalMove() {
		System.out.println(INPUT_TOTAL_MOVE_MESSAGE);
		return Console.readLine();
	}
}
