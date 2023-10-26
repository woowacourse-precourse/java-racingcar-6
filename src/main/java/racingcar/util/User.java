package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class User {
    public List<String> inputCar() {
        String input = Console.readLine();
        List<String> carName = Arrays.asList(input.split(","));
        return carName;
    }

    public int inputTryNumber(){
        String input = Console.readLine();
        int tryNumber = Integer.parseInt(input);
        return tryNumber;
    }
}
