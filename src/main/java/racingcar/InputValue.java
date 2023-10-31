package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.InputValidation.*;
import static racingcar.PrintUtil.*;

public class InputValue {
    public static int movingCount;
    public static String[] carNameList;

    public static void InputSettingValue() {
        printNameOfCarInputMsg();
        carNameList = InputNameOfCars();

        printMoveCountInputMsg();
        movingCount = InputMovingCount();
    }

    public static String[] InputNameOfCars() {
        String userInputCarName = Console.readLine();
        validateInputCorrectSeparator(userInputCarName);

        return createCarList(userInputCarName);
    }

    public static String[] createCarList(String userInputCarName) {
        String[] namesOfCars = userInputCarName.split(MessageConst.STANDARD_SAPARATOR);
        validateNameOfCarsRange(namesOfCars);
        validateDuplicateName(namesOfCars);

        return namesOfCars;
    }

    public static int InputMovingCount() {
        int carMovingCount = Integer.parseInt(Console.readLine());
        validateMoveCountRange(carMovingCount);
        return carMovingCount;
    }
}
