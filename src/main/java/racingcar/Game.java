package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    public static List<Car> readCarNames() {
        String input = Console.readLine();
        Console.close();

        List<String> names = Arrays.asList(input.split(","));
        Validation.validateCarNames(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int readGameCount() {
        String input = Console.readLine();
        Console.close();

        Validation.validateGameCount(input);
        return Integer.parseInt(input);
    }
}
