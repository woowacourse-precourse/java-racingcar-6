package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Player;
import racingcar.model.RacingCup;

public class RacingCupController {
    private RacingCup racingCup;
    private PlayerController playerController;

    public RacingCupController(int totalRounds, PlayerController playerController) {
        this.racingCup = new RacingCup(totalRounds);
        this.playerController = playerController;
    }

    public void addPlayers(List<Player> playerList) {
        this.racingCup.setPlayerList(playerList);
    }

    public boolean nextRound() {
        int round = this.racingCup.getRound();
        if (round < this.racingCup.getFINAL_ROUND()) {
            this.racingCup.setRound(round + 1);
            return true;
        }
        return false;
    }

    public RacingCup getRacingCup() {
        return racingCup;
    }

    public int playerSize() {
        return racingCup.getPlayerList().size();
    }

    public void gamePlay() {
        for (int i = 0; i < playerSize(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                playerController.forward(i);
            }
        }
    }
}
