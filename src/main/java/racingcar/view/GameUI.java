package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.controller.InputHandler;

public class GameUI {

    private GameUI() {
    }

    public static List<String> promptForCarNames() {
        List<String> carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = InputHandler.parseInputToList(Console.readLine());
        return carNames;
    }

    public static int promptForNumberOfRounds() {
        int roundCount;
        System.out.println("시도할 회수는 몇회인가요?");
        roundCount = InputHandler.parseInputToInteger(Console.readLine());
        return roundCount;
    }
}
