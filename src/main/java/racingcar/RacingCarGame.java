package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.car.Car;
import racingcar.car.name.CarName;
import racingcar.result.RacingResult;

public class RacingCarGame {

    private final RacingGameInteractionHandler racingGameInteractionHandler;
    private final CarMovementDecider carMovementDecider;

    public RacingCarGame(
            RacingGameInteractionHandler racingGameInteractionHandler,
            CarMovementDecider carMovementDecider) {
        this.racingGameInteractionHandler = racingGameInteractionHandler;
        this.carMovementDecider = carMovementDecider;
    }

    public void run() {
        List<CarName> carNameList = racingGameInteractionHandler.readCarNameList();
        RacingAttempt racingAttempt = racingGameInteractionHandler.readRacingAttempt();

        List<Car> carList = createCarList(carNameList);
        List<RacingResult> racingResultList = race(carList, racingAttempt);

        racingGameInteractionHandler.printFinalResult(racingResultList);
    }

    private List<Car> createCarList(List<CarName> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .toList();
    }

    private List<RacingResult> race(List<Car> carList, RacingAttempt racingAttempt) {
        racingGameInteractionHandler.announceRaceStart();

        IntStream.range(0, racingAttempt.getAttempts())
                .forEach(i -> {
                    carMovementDecider.move(carList);

                    List<RacingResult> rountResultList = carList.stream()
                            .map(car -> new RacingResult(car.getCarName(), car.getDistanceDriven()))
                            .toList();

                    racingGameInteractionHandler.printRoundResult(rountResultList);
                });

        return carList.stream()
                .map(car -> new RacingResult(car.getCarName(), car.getDistanceDriven()))
                .toList();
    }
}
