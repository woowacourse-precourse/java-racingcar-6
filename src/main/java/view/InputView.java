package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarsName() {
        System.out.println(InputMessage.CARS_NAME_INPUT.getMessage());
        String carsName = Console.readLine();
        return carsName;
    }

    public static String inputAttemptNumber() {
        System.out.println(InputMessage.ATTEMPT_INPUT.getMessage());
        String attemptNumber = Console.readLine();
        System.out.println();
        return attemptNumber;
    }
}
