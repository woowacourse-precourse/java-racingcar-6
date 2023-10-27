package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.PrintUtil.*;

public class InputValue {
    public static void InputSettingValue() {
        printNumberOfCarsInputMsg();
        int inputNumberOfCars = InputNumberOfCars();

        printNameOfCarInputMsg();
        String[] carNameList = InputNameOfCars();

        printMoveCountInputMsg();
        int movingCount = InputMovingCount();
    }

    public static int InputNumberOfCars() {
        int numberOfCars = Integer.parseInt(Console.readLine());
        InputValidation.validateNumberOfCarsRange(numberOfCars);
        return numberOfCars;
    }

    public static String[] InputNameOfCars() {
        String userInputCarName = Console.readLine();
        InputValidation.validateSeparator(userInputCarName);

        String[] nameOfCars = userInputCarName.split(MessageConst.STANDARD_SAPARATOR);
        InputValidation.validateNameOfCarsRange(nameOfCars);
        InputValidation.validateDuplicateName(nameOfCars);

        return nameOfCars;
    }

    public static int InputMovingCount() {
        int carMovingCount = Integer.parseInt(Console.readLine());
        InputValidation.validateMoveCountRange(carMovingCount);
        return carMovingCount;
    }
}
