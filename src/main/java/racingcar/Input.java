package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    static String getCarName() {
        String carNameInput = Console.readLine();
        return (carNameInput);
    }

    static int getTryNumber() {
        String tryNumberInput = Console.readLine();
        int tryNumber = Integer.parseInt(tryNumberInput);
        return (tryNumber);
    }
}
