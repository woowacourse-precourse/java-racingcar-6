package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<String> carNames = new ArrayList<>();
	public static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String QUESTION_CHANCE = "시도할 회수는 몇회인가요?";
	
    public List<String> promptCarNames() {
		System.out.println(START_MESSAGE);
		String inputName = Console.readLine();
		blankName(inputName);

        return Arrays.asList(inputName.split(","));
    }

    public List<String> getCarNames() {
        return carNames;
    }

	public int movingNumber() {
		System.out.println(QUESTION_CHANCE);
		String numberInput = Console.readLine();
		int movingNumber = Integer.parseInt(numberInput);

		if (movingNumber > 0) {
			return movingNumber;
		}
		throw new IllegalArgumentException("회수는 1이상만 가능합니다");
	}

	private void blankName(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("입력 값이 비었습니다");
		}
	}
}


