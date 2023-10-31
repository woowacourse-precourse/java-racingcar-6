package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.controller.InputHandler;

public class GameUI {

    private GameUI() {
    }

    public static List<String> promptForCarNamesAndReturnList() {
        List<String> carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = InputHandler.parseInputToList(Console.readLine());
        return carNames;
    }

    public static int promptForNumberOfRoundsAndReturnInteger() {
    }
}
