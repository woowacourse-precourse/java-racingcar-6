package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    static boolean isEmpty(String[] carNames) {
        if (carNames.length == 0) {
            return (true);
        }
        return (false);
    }
    static String[] getCarName() {
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        if (isEmpty(carNames))
            Exception.generateInvalidCarNumberException();
        return (carNames);
    }

    static int getTryNumber() {
        String tryNumberInput = Console.readLine();
        int tryNumber = Integer.parseInt(tryNumberInput);
        return (tryNumber);
    }
}
