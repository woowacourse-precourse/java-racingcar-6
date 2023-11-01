package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void registerCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public String registerCars() {
        String cars = Console.readLine();
        return cars;
    }

    public String registerAttempt() {
        String attempt = Console.readLine();
        inputValidator.validateAttemptCount(attempt);
        return attempt;
    }
}
