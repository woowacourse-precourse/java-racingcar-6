package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private RacingGameModel model;
    private RacingGameView view;

    public RacingGameController() {
        model = null;
        view = new RacingGameView();
    }

    public void startRacingGame() {
        view.inputForCarNames();
        String carNames = Console.readLine();

        view.inputForAttempts();
        int attempts = Integer.parseInt(Console.readLine());

        model = new RacingGameModel(carNames);

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            model.moveCars();
            view.printRoundResults(model.getCars());
        }

        view.printWinners(model.getWinners());
    }
}
