package racingcar.service;

import racingcar.printer.GameGuidePrinter;

public class GameService {
    private final GameGuidePrinter gameGuidePrinter;

    public GameService() {
        this.gameGuidePrinter = new GameGuidePrinter();
    }

    public void startGame() {
        gameGuidePrinter.getCarNameInputMessage();
//        String carList = carNameInput();
        gameGuidePrinter.getTryCountMessage();
    }
}