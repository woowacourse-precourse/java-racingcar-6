package racingcar.domain;

import static racingcar.Utils.makeRandomNumber;
import static racingcar.constant.NumberConstants.ZERO;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        carNames.forEach(carName -> racingCarList.add(new RacingCar(carName)));
    }

    public List<String> playRound() {
        moveRacingCar();
        return racingCarList.stream()
                .map(RacingCar::createRoundResult)
                .toList();
    }

    private void moveRacingCar() {
        racingCarList.forEach(racingCar -> racingCar.move(makeRandomNumber()));
    }

    public List<String> noticeWinners() {
        return racingCarList.stream()
                .filter(racingCar -> racingCar.isWinner(findMaxPosition()))
                .map(RacingCar::createWinnerName)
                .toList();
    }

    private int findMaxPosition() {
        return racingCarList.stream()
                .mapToInt(RacingCar::createMaxPosition)
                .max()
                .orElse(ZERO);
    }

}
