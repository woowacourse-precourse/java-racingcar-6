package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class inputReader {

    public static List<Car> readCars() {
        String input = Console.readLine();
        InputValidator.validateCarsInput(input);

        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int readTryCount() {
        return Converter.convertToValidInteger(Console.readLine());
    }
}
