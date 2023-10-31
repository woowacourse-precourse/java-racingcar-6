package racingcar.service;

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

    public void getRacingResult() {
        String winner = String.join(", ", cars.getWinner());
        Message.printRacingResultMessage(winner);
    }

}