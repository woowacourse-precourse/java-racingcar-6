package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Controller.Controller;

public class InputView {
    Controller controller = new Controller();

    public void playGame() {
        controller.requestStartGame();
    }

    public void askForCarNames() {
        String[] names = getCarNames();
        controller.requestCarGenerate(names);
    }


    public void askForAttempts() {
        int attempts = getAttempts();
        controller.requestSetAttempts(attempts);
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    private int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}
