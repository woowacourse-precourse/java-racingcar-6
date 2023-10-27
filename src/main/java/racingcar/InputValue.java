package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputValue {

    public static int InputNumberOfCars() {
        int numberOfCars = Integer.parseInt(Console.readLine());
        validateNumberOfCarsRange(numberOfCars);
        return numberOfCars;
    }

    public static String[] InputNameOfCars() {
        String userInputCarName = Console.readLine();
        validateSeparator(userInputCarName);
        String[] nameOfCars = userInputCarName.split(",");
        validateNameOfCarsRange(nameOfCars);
        validateDuplicateName(nameOfCars);
        return nameOfCars;
    }

    public static int InputMovingCount() {
        int carMovingCount = Integer.parseInt(Console.readLine());
        validateMoveCountRange(moveCount);
        return carMovingCount;
    }
}
