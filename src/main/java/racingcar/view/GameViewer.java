package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCarGameMachine;

import java.util.List;

public class GameViewer {
    private RacingCarGameMachine racingCarGameMachine = new RacingCarGameMachine();

    public void startMessage() {
        System.out.println(GameMessage.START_MESSAGE.getStartMessage());
    }

    public void tryCountMessage() {
        System.out.println(GameMessage.REQUEST_TRY_MESSAGE.getRequestTryMessage());
    }

    public void gameResultMessage() {
        System.out.println("\n" + GameMessage.GAME_RESULT_MESSAGE.getGameResultMessage());
    }

    public void racingResultViewer(List<String> carNames, String tryCount) {
        racingCarGameMachine.readyToPlay(carNames);
        for (int i = 0; i < Integer.parseInt(tryCount); i++) {
            racingCarGameMachine.race();
            racingCarsStatusViewer();
        }
    }

    public void racingCarsStatusViewer() {
        List<RacingCar> racingCars = racingCarGameMachine.getRacingCars();
        racingCars.forEach(System.out::println);
        System.out.print("\n");
    }

    public void gameWinnerViewer() {
        String winners = String.join(",", racingCarGameMachine.getWinner());
        System.out.println(GameMessage.WINNER_MESSAGE.getWinnerMessage(winners));
    }

}
