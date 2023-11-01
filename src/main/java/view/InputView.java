package view;

import camp.nextstep.edu.missionutils.Console;
import validators.InputValidator;

public class InputView {
	
	private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TOTAL_MOVE_MESSAGE = "시도할 회수는 몇회인가요?";

	public static String nameText() throws IllegalArgumentException {
		System.out.println(INPUT_CAR_NAME_MESSAGE);
		String inputCarName = Console.readLine().trim();
		InputValidator.checkNull(inputCarName);
		
		return inputCarName;
	}
	
	public static String totalMove() throws IllegalArgumentException {
		System.out.println(INPUT_TOTAL_MOVE_MESSAGE);
		String inputTotalMove = Console.readLine().trim();
		InputValidator.checkNull(inputTotalMove);
		InputValidator.checkCarMoveFomat(inputTotalMove);
		
		return inputTotalMove;
	}
}
