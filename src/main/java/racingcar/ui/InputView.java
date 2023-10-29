package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {
    private final InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validator.validate(carNames);
        return carNames;
    }

    public String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();
        System.out.println();
        validator.validate(tryCount);
        return tryCount;
    }
}
