package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Player;
import racingcar.model.RacingCup;

public class RacingCupController {
    private RacingCup racingCup;
    private PlayerController playerController;
    private static final int FORWARD_THRESHOLD = 4;

    public RacingCupController(int totalRounds, PlayerController playerController) {
        this.racingCup = new RacingCup(totalRounds);
        this.playerController = playerController;
    }

    public boolean playNextRound() {
        return racingCup.nextRound();
    }

    public void playRacingGame() {
        for (int i = 0; i < playerController.getSizeOfTotalPlayers(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
                playerController.forward(i);
            }
        }
    }

    public void updateTopPlayerCompletedRound() {
        for (int i = 0; i < playerController.getSizeOfTotalPlayers(); i++) {
            racingCup.updateTopPlayerCompletedRound(playerController.getCompletedRounds(i));
        }
    }

    public void decideFinalWinner() {
        for (int i = 0; i < playerController.getSizeOfTotalPlayers(); i++) {
            if (racingCup.getTopPlayerCompletedRound() == playerController.getCompletedRounds(i)) {
                racingCup.addCarNameOfTheWinner(playerController.getCarNameOfThePlayer(i));
            }
        }
    }

    public List<String> getFinalWinners() {
        return racingCup.getFinalWinners();
    }
}
