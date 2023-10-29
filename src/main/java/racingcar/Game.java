package racingcar;

import racingcar.engine.GameEngine;
import racingcar.reader.InputReader;
import racingcar.ui.Ui;

public class Game {
    private final Ui ui;
    private final InputReader inputReader;
    private final GameEngine gameEngine;

    public Game(AppConfig appConfig) {
        this.ui = appConfig.getUi();
        this.inputReader = appConfig.getInputReader();
        this.gameEngine = appConfig.getGameEngine();
    }

    public void run() {
        start();
        playing();
        end();
    }

    private void start() {
        ui.start();
        gameEngine.initScore(inputReader.readLine());
    }

    private void playing() {
        ui.printGameStatusGuide();
        String playCount = inputReader.readLine();
        gameEngine.validatePlayCount(playCount);
        for (long i = 0; i < Long.parseLong(playCount); i++) {
            gameEngine.run();
            ui.printGameStatus(gameEngine.getScores());
        }
    }

    private void end() {
        ui.printGameWinners(gameEngine.getWinners());
        inputReader.close();
    }
}
