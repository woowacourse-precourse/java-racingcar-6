package racingcar.model;

import java.util.List;
import racingcar.vo.CarName;

public class RacingGame {

    private final Cars cars;
    private final Referee referee;

    public RacingGame(final Cars cars, final Referee referee) {
        this.cars = cars;
        this.referee = referee;
    }

    public void proceedOneRound() {
        cars.updatePosition();
    }

    public List<String> getWinners() {
        referee.decideWinner(cars.getCarList());
        List<CarName> winnerNames = referee.getWinnerNames();

        return winnerNames.stream()
                .map(carName -> carName.name())
                .toList();
    }
}
