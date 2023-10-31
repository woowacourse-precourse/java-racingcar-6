package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CountInputValidator;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final CountInputValidator countInputValidator = new CountInputValidator();

    public String getCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public int getCountInput() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String playerInput = Console.readLine();
        countInputValidator.validate(playerInput);
        return Integer.parseInt(playerInput);
    }
}
