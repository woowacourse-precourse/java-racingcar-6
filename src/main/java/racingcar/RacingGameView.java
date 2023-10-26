package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameView {

    private static final String NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ERROR_NAME_LENGTH = "이름은 5글자 이하만 가능합니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public void inputCarNames() {
        System.out.println(NAME_INPUT_GUIDE);
        String carNames = Console.readLine();
        validateCarNames(carNames);
    }

    public void validateCarNames(String input) {
        String[] result = input.split(",");

        for (String name : result) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }
}
