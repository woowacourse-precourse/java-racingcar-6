package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.InputValidation.*;
import static racingcar.PrintUtil.*;

public class InputValue {
    public static int inputNumberOfCars, movingCount;
    public static String[] carNameList;

    public static void InputSettingValue() {
        printNumberOfCarsInputMsg();
        inputNumberOfCars = InputNumberOfCars();

        printNameOfCarInputMsg();
        carNameList = InputNameOfCars();

        printMoveCountInputMsg();
        movingCount = InputMovingCount();
    }

    public static int InputNumberOfCars() {
        int numberOfCars = Integer.parseInt(Console.readLine());
        validateNumberOfCarsRange(numberOfCars);
        return numberOfCars;
    }

    public static String[] InputNameOfCars() {
        String userInputCarName = Console.readLine();
        validateInputCorrectSeparator(userInputCarName);

        String[] namesOfCars = userInputCarName.split(MessageConst.STANDARD_SAPARATOR);
        validateInputEnoughNames(inputNumberOfCars, namesOfCars);
        validateNameOfCarsRange(namesOfCars);
        validateDuplicateName(namesOfCars);

        return namesOfCars;
    }

    public static int InputMovingCount() {
        int carMovingCount = Integer.parseInt(Console.readLine());
        InputValidation.validateMoveCountRange(carMovingCount);
        return carMovingCount;
    }
}
