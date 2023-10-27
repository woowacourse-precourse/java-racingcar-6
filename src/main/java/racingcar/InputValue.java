package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputValue {

    public static int InputNumberOfCars() {
        int numberOfCars = Integer.parseInt(Console.readLine());
        InputValidation.validateNumberOfCarsRange(numberOfCars);
        return numberOfCars;
    }

    public static String[] InputNameOfCars() {
        String userInputCarName = Console.readLine();
        InputValidation.validateSeparator(userInputCarName);
        String[] nameOfCars = userInputCarName.split(",");
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
