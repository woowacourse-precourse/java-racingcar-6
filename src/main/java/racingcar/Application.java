package racingcar;

import java.util.List;
import racingcar.controller.PlayerController;
import racingcar.controller.RacingCupController;
import racingcar.model.Player;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        List<String> carNames = gameView.getCarNames();

        PlayerController playersController = new PlayerController();
        RacingCupController racingCupController = new RacingCupController(gameView.getTotalRounds(), playersController);

        playersController.addPlayer(carNames);
        racingCupController.addPlayers(playersController.getPlayerList());

        gameView.printMessage("실행결과");
        while(racingCupController.nextRound()) {
            racingCupController.gamePlay();
            for(int i = 0; i < playersController.getPlayerList().size(); i++) {
                System.out.print(i+1+"번 : ");
                System.out.println(playersController.getDistacne(i));
            }
        }
    }
}
