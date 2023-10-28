package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {

    private InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String carName = Console.readLine();
        inputValidator.validateInputCarName(carName);
        return carName;
    }

    public Integer inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();
        inputValidator.validateInputTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }
}
