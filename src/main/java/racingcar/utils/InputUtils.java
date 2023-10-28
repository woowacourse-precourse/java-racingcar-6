package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class InputUtils {
    public static List<Car> promptForCar() {
        return Arrays.stream(Console.readLine().split(","))
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public static int promptForInt() {
        return Integer.parseInt(Console.readLine());
    }
}
