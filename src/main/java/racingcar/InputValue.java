package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.InputValidation.*;
import static racingcar.PrintUtil.*;

public class InputValue {
    private static final String nameSeperator = ",";
    public static int movingCount;
    public static String[] carNameList;

    public static void inputSettingValue() {
        printNameOfCarInputMsg();
        carNameList = inputNameOfCars();

        printMoveCountInputMsg();
        movingCount = inputMovingCount();
    }

    public static String[] inputNameOfCars() {
        String userInputCarName = Console.readLine();
        validateInputCorrectSeparator(userInputCarName);

        return createCarList(userInputCarName);
    }

    public static String[] createCarList(String userInputCarName) {
        String[] namesOfCars = userInputCarName.split(nameSeperator);
        validateNameOfCarsLength(namesOfCars);
        validateDuplicateName(namesOfCars);

        return namesOfCars;
    }

    public static int inputMovingCount() {
        int carMovingCount = Integer.parseInt(Console.readLine());
        validateMoveCountRange(carMovingCount);
        return carMovingCount;
    }
}
