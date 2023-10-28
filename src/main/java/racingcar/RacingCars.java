package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;

public class RacingCars {
    static List<String> generateCar() {
        String tmp_cars = Console.readLine();
        List<String> Cars = Arrays.asList(tmp_cars.split(","));
        Exceptions.ExceptCars(Cars);
        return Cars;
    }
}
