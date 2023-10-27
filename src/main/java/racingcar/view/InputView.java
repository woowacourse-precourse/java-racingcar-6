package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CountInputValidator;
import racingcar.validator.NamesInputValidator;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final NamesInputValidator nameInputValidator = new NamesInputValidator();
    private final CountInputValidator countInputValidator = new CountInputValidator();

    public String getCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String playerInput = Console.readLine();
        nameInputValidator.validate(playerInput);
        return playerInput;
    }

    public String getCountInput() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String playerInput = Console.readLine();
        countInputValidator.validate(playerInput);
        System.out.println(playerInput);
        return playerInput;
    }
}
