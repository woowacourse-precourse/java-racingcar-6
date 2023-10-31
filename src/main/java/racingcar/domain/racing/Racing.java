package racingcar.domain.racing;

import java.util.ArrayList;
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

    public void race() {
        List<RacingMovement> randomMoves = new ArrayList<>();

        for (RacingCar car : cars.getCars()) {
            RacingMovement move = new RacingMovement(car.getName());

            if (move.isMovingForward()) {
                car.moveForward();
            }

            randomMoves.add(move);
        }

        printer.updateRacingResult(randomMoves);
    }

    public String getTotalRacingResult() {
        return printer.getRacingResult();
    }

    public List<String> getFinalWinnerList() {
        RacingResult racingResult = new RacingResult(cars);
        return racingResult.getFinalWinnerList();
    }
}