package racingcar.controller;

import racingcar.configurator.GameSetter;

public class GameController {
    private final GameSetter gameSetter;
    private final GameRule gameRule;

    public GameController(GameSetter gameSetter, GameRule gameRule) {
        this.gameSetter = gameSetter;
        this.gameRule = gameRule;
    }

    public void run() {
        gameSetter.registerCars();
        playGame();
    }

    void playGame() {
        for (int i = 0; i < gameSetter.getCoin(); i++) {
            gameRule.playRound();
        }
        printWinner();
    }

    void printWinner() {
        String winnerName = gameRule.calculateWinner();
        System.out.println("최종 우승자 : " + winnerName);
    }
}
