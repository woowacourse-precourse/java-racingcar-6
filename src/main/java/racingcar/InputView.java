package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NOT_PERMIT_BLANK = "공백은 허용하지 않습니다.";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String HOW_MANY_TRY_MESSAGE = "시도할 회수는 몇회인가요?";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return validInputBlank(Console.readLine());
    }

    // 문자열에 공백이 포함되어 있거나, 아무것도 입력받지 않았을 때 예외가 발생합니다.
    private String validInputBlank(String input) {
        if ((input.isEmpty() || input.contains(" "))) {
            throw new IllegalArgumentException(NOT_PERMIT_BLANK);
        }
        return input;
    }

    public void inputHowManyTry() {
        System.out.println(HOW_MANY_TRY_MESSAGE);
    }

}
