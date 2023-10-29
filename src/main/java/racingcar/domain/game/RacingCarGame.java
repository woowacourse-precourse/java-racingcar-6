package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.utils.RandomNumberGenerator;

public class RacingCarGame {
    private Cars cars;
    private int round;

    public void init(String names, int round) {
        cars = generateCars(names);
        this.round = round;
    }

    public void raceByRound() {
        for (int i = 0; i < round; i++) {
            List<Integer> numbers = generateRandomNumbers();
            moveCarByNumber(numbers);
        }
    }

    private Cars generateCars(String names) {
        return new Cars(names);
    }

    private List<Integer> generateRandomNumbers() {
        return Stream.generate(() -> RandomNumberGenerator.generate())
                .limit(cars.size())
                .collect(Collectors.toList());
    }

    private void moveCarByNumber(List<Integer> numbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.findCarByIndex(i);
            car.move(numbers.get(i));
        }
    }
}
