package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class RacingGameService {

    public void determineMoveForward(Car car) {
        if (generateRandomNumber() >= 4) {
            car.moveCar();
        }
    }

    public CarList makeCarList(List<String> carNames) {
        List<Car> collect = carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        return new CarList(collect);
    }

    public List<String> splitStringToList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    private int generateRandomNumber() {
        return pickNumberInRange(0, 9);
    }
}
