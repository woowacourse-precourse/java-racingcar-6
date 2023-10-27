package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.input.UserInputReader;
import racingcar.racingcar.RacingCar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        UserInputReader userInputReader = new UserInputReader();

        String cars = userInputReader.readLine();

        List<String> carsList = Stream.of(cars.split(",", -1)).collect(Collectors.toList());

        RacingCar racingCar = new RacingCar(carsList);

    }
}
