package racingcar.domain;

import static racingcar.domain.InputToCarList.getInstance;

import java.util.List;
import racingcar.controller.RacingGameController;

public class RacingCarGame {

    private final Referee referee;
    private final RacingGameController controller;

    public RacingCarGame(Referee referee, RacingGameController controller) {
        this.referee = referee;
        this.controller = controller;
    }

    public List<Car> gameStart(String verifiedInput, Integer tryCount) {
        List<Car> carNameList = getInstance().askCarNameToCarList(verifiedInput);

        for (int i = 0; i < tryCount; i++) {
            controller.getGameResult(carNameList, referee);
        }

        return carNameList;
    }
}
