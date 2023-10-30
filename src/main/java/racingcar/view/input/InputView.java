package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.view.input.validator.UserInputValidator;

public class InputView {

    private final UserInputValidator userInputValidator;

    public InputView(UserInputValidator userInputValidator) {
        this.userInputValidator = userInputValidator;
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String rawInput = Console.readLine();

        return convertCarNames(rawInput);
    }

    public Integer getRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        String rawInput = Console.readLine();

        return convertRoundCount(rawInput);
    }

    private List<String> convertCarNames(String rawInput) {
        List<String> carNameList = Arrays.stream(rawInput.split(","))
                .toList();

        userInputValidator.validateCarNames(carNameList);

        return carNameList;
    }

    private Integer convertRoundCount(String rawInput) {
        userInputValidator.validateRoundCount(rawInput);

        return Integer.valueOf(rawInput);
    }
}
