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

    public boolean nextRound() {
        int round = this.racingCup.getRound();
        if(round < this.racingCup.getFINAL_ROUND()) {
            this.racingCup.setRound(round + 1);
            return true;
        }
        return false;
    }

    public RacingCup getRacingCup() {
        return racingCup;
    }
}
