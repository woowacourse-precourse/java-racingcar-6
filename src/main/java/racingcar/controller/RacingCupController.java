package racingcar.controller;

import java.util.List;
import racingcar.model.Player;
import racingcar.model.RacingCup;

public class RacingCupController {
    private List<Player> playerList;
    private RacingCup racingCup;
    public RacingCupController(int totalRounds) {
        this.racingCup = new RacingCup(totalRounds);
    }

}
