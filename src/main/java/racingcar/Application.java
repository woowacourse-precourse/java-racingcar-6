package racingcar;

import java.util.List;
import racingcar.controller.PlayerController;
import racingcar.controller.RacingCupController;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        List<String> carNames = gameView.getCarNames();

        RacingCupController racingCupController = new RacingCupController(gameView.getTotalRounds());
        PlayerController playersController = new PlayerController();

        playersController.addPlayer(carNames);
        racingCupController.addPlayers(playersController.getPlayerList());

        while(racingCupController.nextRound()) {
            System.out.println("라운드 : " + racingCupController.getRacingCup().getRound());
        }
    }
}
