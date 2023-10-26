package game;

import exception.GameInputException;
import view.InputView;

public class RacingGame {

    private final InputView inputView;
    private final GameInputException gameInputException;

    public RacingGame() {
        inputView = new InputView();
        gameInputException = new GameInputException();
    }

    public void run() {
        String[] names = preHandleNames();
        int count = preHendleCount();
    }

    private String[] preHandleNames() {
        String input = inputView.inputCarNames();
        String[] names = input.split(",");
        gameInputException.validateNameLength(names);
        return names;
    }

    private int preHendleCount() {
        String input = inputView.inputRaceCount();
        gameInputException.validateNumber(input);
        gameInputException.validateNumberZero(input);
        return Integer.parseInt(input);
    }


}
