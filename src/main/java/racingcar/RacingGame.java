package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }
    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            playRound();
            OutputView.printCars(cars);
        }
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = car.getRandomNumber();
            car.move(randomNumber);
        }
    }
    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }


}
