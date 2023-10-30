package racingcar.domain;

import static racingcar.Utils.findMaxInteger;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.RacingOutputView;

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

    public void noticeWinners() {
        RacingOutputView.outputWinners(racingCarList.stream()
                .filter(racingCar -> racingCar.isWinner(findMaxInteger(findPositions())))
                .map(RacingCar::getCarName)
                .toList());
    }

    private List<Integer> findPositions() {
        return racingCarList.stream()
                .map(RacingCar::getPosition)
                .toList();
    }

}
