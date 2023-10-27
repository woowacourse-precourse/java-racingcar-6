package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarsName() {
        System.out.println(InputMessage.CARS_NAME_INPUT.getMessage());
        String carsName = Console.readLine();
        return carsName;
    }
}
