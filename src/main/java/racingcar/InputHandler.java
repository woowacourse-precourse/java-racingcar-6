package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public static List<Car> initCars() {
        String input = Console.readLine();
        List<String> names = Arrays.stream(input.split(",")).toList();
        List<Car> ret = new ArrayList<>();
        names.forEach(name ->
                ret.add(new Car(name))
        );
        return ret;
    }

    public static int getInteger() {
        String input = Console.readLine();
        Validation.validateIsNumber(input);
        int tryCount = Integer.parseInt(input);
        Validation.validateNaturalNumber(tryCount);
        return tryCount;
    }
}
