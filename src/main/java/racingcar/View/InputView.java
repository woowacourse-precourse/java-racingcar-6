package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Controller.Controller;

public class InputView {
    Controller controller = new Controller();

    public void askForCarNames() {
        String[] names = getCarNames();
        controller.requestCarGenerate(names);
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

}
