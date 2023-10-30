package racingcar.controller;

import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private RacingGameModel model;
    private RacingGameView view;
    private static final String RESULT_MESSAGE = "실행 결과";

    // 생성자
    public RacingGameController() {
        model = null;
        view = new RacingGameView();
    }

    public void startRacingGame() {
        String carNames = view.readCarNamesFromConsole();
        int attempts = view.convertAttemptsToIntFromConsoleStringInput();

        model = new RacingGameModel(carNames);

        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < attempts; i++) {
            model.moveCars();
            view.printRoundResults(model.getCars());
        }

        view.printWinners(model.getWinners());
    }
}