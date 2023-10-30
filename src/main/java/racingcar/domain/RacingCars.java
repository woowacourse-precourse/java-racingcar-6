package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.output.RacingOutputView;

public class RacingCars {

    private final List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        carNames.forEach(carName -> racingCarList.add(new RacingCar(carName)));
    }

    public void playRound() {
        moveRacingCar();
        RacingOutputView.outputRoundResults(
                racingCarList.stream()
                        .map(RacingCar::createRoundResult)
                        .toList()
        );
    }

    private void moveRacingCar() {
        racingCarList.forEach(RacingCar::move);
    }

}
