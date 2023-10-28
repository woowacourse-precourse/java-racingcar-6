package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameMachine;

import java.util.List;

public class GameViewer {
    private RacingCarGameMachine racingCarGameMachine = new RacingCarGameMachine();

    public void startMessage() {
        System.out.println(GameMessage.START_MESSAGE.getGameResultMessage());
    }

    public void tryCountMessage() {
        System.out.println(GameMessage.REQUEST_TRY_MESSAGE.getRequestTryMessage());
    }

    public void gameResultMessage() {
        System.out.println("\n" + GameMessage.GAME_RESULT_MESSAGE.getGameResultMessage());
    }

    public void racingCarsStatusViewer(List<String> carNames, int tryCount) {
        racingCarGameMachine.gamePlay(carNames, tryCount);
        List<RacingCar> racingCars = racingCarGameMachine.getRacingCars();

        for (RacingCar car : racingCars) {
            System.out.print(car);
        }
        System.out.println("\n");
    }

    public void gameWinnerViewer() {
        String winners = String.join(",", racingCarGameMachine.winner());
        System.out.println(winners);
    }

}
