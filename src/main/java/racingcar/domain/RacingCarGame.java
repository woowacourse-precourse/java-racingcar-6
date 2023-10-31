package racingcar.domain;

import static racingcar.domain.InputToCarList.getInstance;

import java.util.List;
import racingcar.controller.RaceController;

public class RacingCarGame {

    private final Referee referee;
    private final RaceController controller;

    public RacingCarGame(Referee referee, RaceController controller) {
        this.referee = referee;
        this.controller = controller;
    }

    public List<Car> gameStart(String verifiedInput, Integer tryCount) {
        List<Car> carNameList = getInstance().askCarName(verifiedInput);

        for (int i = 0; i < tryCount; i++) {
            controller.getWinner(carNameList, referee);
        }

        return carNameList;
    }
}
