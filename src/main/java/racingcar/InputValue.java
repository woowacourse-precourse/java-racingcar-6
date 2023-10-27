package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputValue {

    public static int InputNumberOfCars() {
        int numberOfCars = Integer.parseInt(Console.readLine());
        validateNumberOfCarsRange(numberOfCars);
        return numberOfCars;
    }

}
