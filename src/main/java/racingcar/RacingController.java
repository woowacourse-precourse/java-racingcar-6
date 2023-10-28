package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingController {
    private Exception exception = new Exception();
    private ConsolePrint consolePrint = new ConsolePrint();
    public void startGame() {
        consolePrint.requestCarNameInput();
        String carName = Console.readLine();
        exception.isCarNameValid(carName);

        consolePrint.requestTryCountInput();
        String tryCount = Console.readLine();
        exception.isTryCountValid(tryCount);
    }
}
