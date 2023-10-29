package racingcar.controller;

import java.util.List;
import racingcar.model.Player;
import racingcar.model.RacingCup;

public class RacingCupController {
    private RacingCup racingCup;
    public RacingCupController(int totalRounds) {
        this.racingCup = new RacingCup(totalRounds);
    }

    public void addPlayers(List<Player> playerList) {
        this.racingCup.setPlayerList(playerList);
    }

    public RacingCup getRacingCup() {
        return racingCup;
    }
}
