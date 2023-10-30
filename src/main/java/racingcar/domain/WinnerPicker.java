package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerPicker {

    public Winners pickWinner(RacingCars racingCars) {
        List<String> winnersName = new ArrayList<>();
        int winnerDistance = racingCars.getMaxForwardDistance();

        racingCars.getRacingCars().stream()
                .filter(racingCar -> racingCar.getForwardDistance() == winnerDistance)
                .map(RacingCar::getName)
                .forEach(winnersName::add);

        return new Winners(winnersName);
    }
}
