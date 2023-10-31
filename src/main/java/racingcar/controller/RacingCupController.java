package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.RacingCup;

public class RacingCupController {
    private RacingCup racingCup;
    private PlayerController playerController;

    public RacingCupController(int totalRounds, PlayerController playerController) {
        this.racingCup = new RacingCup(totalRounds);
        this.playerController = playerController;
    }

    public boolean nextRound() {
        return racingCup.nextRound();
    }

    public void gamePlay() {
        for (int i = 0; i < playerController.getSizeOfTotalPlayers(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                playerController.forward(i);
                racingCup.updateTopPlayerCompletedRound(playerController.getCompletedRounds(i));
            }
        }
    }

    public void decideFinalWinner() {
        for(int i = 0; i < playerController.getSizeOfTotalPlayers(); i++) {
            if(racingCup.getTopPlayerCompletedRound() == playerController.getCompletedRounds(i)) {
                racingCup.addCarNameOfTheWinner(playerController.getCarNameOfThePlayer(i));
            }
        }
    }

    public List<String> getFinalWinners() {
        return racingCup.getFinalWinners();
    }
}
