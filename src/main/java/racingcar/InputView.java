package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCarsName() {
        String carsName = Console.readLine();
        return carsName;
    }

    public static String getTryNumber() {
        String tryNumber = Console.readLine();
        return tryNumber;
    }

    public static String[] splitCarName(String input) {
        String[] result = input.split(",");

        return result;
    }


}
