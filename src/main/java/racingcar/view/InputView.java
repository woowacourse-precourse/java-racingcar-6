package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Controller;
import racingcar.model.validation.ValidatorAttempts;

public class InputView {
    Controller controller = new Controller();
    ValidatorAttempts validator = new ValidatorAttempts();

    public void askForCarNames() {
        String[] names = getCarNames();
        controller.requestCarGenerate(names);
        controller.requestSetCarAmount(names);
    }

    public void askForAttempts() {
        int attempts = getAttempts();
        controller.requestSetAttempts(attempts);
    }

    public void playGame() {
        controller.requestStartGame();
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    private int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validator.isValid(input);
        return Integer.parseInt(input);
    }

}
