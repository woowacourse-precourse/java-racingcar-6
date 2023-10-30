package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public static String[] getCarNames() {
        OutputManager.promptForCarNames();
        String carNameInput = Console.readLine();
        return carNameInput.split(",");
    }

    public static int getTrials() {
        OutputManager.promptForTrials();
        return Integer.parseInt(Console.readLine());
    }

}
