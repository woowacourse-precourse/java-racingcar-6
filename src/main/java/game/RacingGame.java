package game;

import controller.GameController;

import exception.GameInputException;

import view.InputView;

public class RacingGame {

    private static RacingGame defaultRacingGame;
    private final InputView inputView;
    private final GameInputException gameInputException;
    private final GameController gameController;

    private RacingGame() {
        inputView = InputView.getInstance();
        gameInputException = GameInputException.getInstance();
        gameController = GameController.getInstance();
    }

    public static RacingGame getInstance() {
        if(defaultRacingGame == null) {
            defaultRacingGame = new RacingGame();
        }
        return defaultRacingGame;
    }

    public void run() {
        String[] names = preHandleNames();
        int count = preHandleCount();
        gameController.raceSet(names);
        gameController.race(count);
        gameController.raceResult();
    }

    private String[] preHandleNames() {
        String input = inputView.inputCarNames();
        String[] names = input.split(",");
        gameInputException.validateNameLength(names);
        return names;
    }

    private int preHandleCount() {
        String input = inputView.inputRaceCount();
        gameInputException.validateNumber(input);
        gameInputException.validateNumberZero(input);
        return Integer.parseInt(input);
    }

    public void close() {
        gameController.close();
        gameInputException.close();
        inputView.close();
        defaultRacingGame = null;
    }

}
