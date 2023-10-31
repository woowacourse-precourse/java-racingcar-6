package racingcar;

import java.util.List;
import racingcar.controller.PlayerController;
import racingcar.controller.RacingCupController;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        List<String> carNames = gameView.getCarNames();

        PlayerController playersController = new PlayerController();
        RacingCupController racingCupController = new RacingCupController(gameView.getTotalRounds(), playersController);
        playersController.addPlayer(carNames);

        gameView.printMessage("실행결과");
        while(racingCupController.nextRound()) {
            racingCupController.gamePlay();
            gameView.nowRoundResultPrint(playersController.getPlayerList());
        }

        racingCupController.decideFinalWinner();
        gameView.finalResultPrint(racingCupController.getFinalWinners());
    }
}
