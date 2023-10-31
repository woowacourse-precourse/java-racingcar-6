package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.Message;

public class RacingService {

    private Cars cars;
    private int racingCount;

    public RacingService(Cars cars, int racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public void startRacing() {
        moveAllRacingCar(racingCount);
    }

    private void moveAllRacingCar(int count) {
        while (count-- > 0) {
            cars.moveCars();
            Message.printMoveResultMessage(cars.getCarList());
        }
    }

    public void getWinner() {
        String winner = String.join(", ", calculateRaceResults());
        Message.printRacingResultMessage(winner);
    }

    private List<String> calculateRaceResults() {
        int maxMoveCount = cars.getCarList().stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.getCarList().stream()
                .filter(x -> x.getMoveCount() == maxMoveCount)
                .map(x -> new String(x.getName()))
                .toList();
    }

}