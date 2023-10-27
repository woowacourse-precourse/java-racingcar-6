package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.input.CarNamesInputReader;
import racingcar.input.NumberOfMovementInputReader;
import racingcar.racingcar.RacingCar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarNamesInputReader carNamesInputReader = new CarNamesInputReader();

        List<String> carsList = Stream.of(carNamesInputReader.readLine().split(",", -1)).collect(Collectors.toList());

        RacingCar racingCar = new RacingCar(carsList);


        NumberOfMovementInputReader number = new NumberOfMovementInputReader();

        int numberOfMovement = Integer.parseInt(number.readLine());


    }
}
