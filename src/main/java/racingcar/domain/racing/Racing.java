package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;


public class Racing {
    private RacingCars cars;
    private int round;
    private RacingPrinter printer;

    public Racing(RacingCars cars, int round) {
        this.cars = cars;
        this.round = round;
        this.printer = new RacingPrinter();
    }

    public void process() {
        while (round-- > 0) {
            race();
        }
    }

    private void race() {
        for (RacingCar car : cars.getCars()) {
            RacingMovement move = RacingMovement.random();

            if (move.isMovingForward()) {
                car.moveForward();
            }
        }

        printer.updateRacingResult(cars);
    }

    public int getRound() {
        return round;
    }

    public String getTotalRacingResult() {
        return printer.getRacingResult();
    }

    public List<String> getFinalWinnerList() {
        RacingResult racingResult = new RacingResult(cars);
        return racingResult.getFinalWinnerList();
    }
}