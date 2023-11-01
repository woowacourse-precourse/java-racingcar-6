package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    public static void getCarName() {
        String carsInput = Console.readLine();
        List<String> cars = Arrays.asList(carsInput.split(","));
    }
}
