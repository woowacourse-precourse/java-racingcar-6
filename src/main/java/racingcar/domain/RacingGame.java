package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static RacingGame instance;
    private final List<Car> cars;

    private RacingGame() {
        cars = new ArrayList<>();
    }

    public static RacingGame getInstance() {
        if (instance == null) {
            instance = new RacingGame();
        }
        return instance;
    }

    public void addCar(String input) {

        String[] carNames = input.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void play(String input) {


    }


    public String getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", winners);
    }

}
