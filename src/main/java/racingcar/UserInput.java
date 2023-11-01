package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    public static List<String> getCarName() {
        String carsInput = Console.readLine();
        List<String> cars = Arrays.asList(carsInput.split(","));
        ExceptionControl.checkCarNameInput(cars);

        return cars;
    }

    public static int getGameCount() {
        String gameCount = Console.readLine();

        return Integer.parseInt(gameCount);
    }
}
