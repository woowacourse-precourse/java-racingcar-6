package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.raingcar.RacingCar;
import racingcar.domain.raingcar.RacingCars;


public class Racing {
    private RacingCars racingCars;
    private int round;
    private RacingPrinter racingPrinter;

    public Racing(RacingCars cars, int round) {
        this.racingCars = cars;
        this.round = round;
        this.racingPrinter = new RacingPrinter();
    }

    public void process() {
        while (round-- > 0) {
            race();
        }
    }

    private void race() {
        List<RacingMovement> randomMoves = new ArrayList<>();
        for (RacingCar car : racingCars.getCars()) {
            RacingMovement move = new RacingMovement(car.getName());

            if (move.isMovingForward()) {
                car.updatePosition();
            }

            randomMoves.add(move);
        }
        racingPrinter.updateRacingResult(randomMoves);
    }

    public String getTotalRacingResult() {
        return racingPrinter.getRacingResult();
    }

    public List<String> getFinalWinnerList() {
        return RacingResult.getFinalWinners(racingCars);
    }
}