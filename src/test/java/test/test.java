package test;

import java.util.List;
import racingcar.controller.PlayerController;
import racingcar.controller.RacingCupController;
import racingcar.view.GameView;

public class test {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        System.out.print("자동차 입력 : ");
        List<String> carNames = gameView.getCarNames();
        System.out.println(carNames);

        System.out.print("시도할 횟수 입력 : ");
        int round = gameView.getTotalRounds();
        System.out.println("totalround = " + round);

        PlayerController playerController = new PlayerController();
        playerController.addPlayer(carNames);
        System.out.println(playerController.getPlayerList());

        RacingCupController racingCupController = new RacingCupController(round, playerController);
        racingCupController.addPlayers(playerController.getPlayerList());
        System.out.println(racingCupController.getRacingCup());

    }
}
