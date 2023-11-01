package controller;

import configuration.GameSetter;

public class GameController {
    private final GameSetter racingGame;
    private final GameRule gameRule;

    public GameController(GameSetter racingGame, GameRule gameRule) {
        this.racingGame = racingGame;
        this.gameRule = gameRule;
    }

    public void run() {
        racingGame.setGame();
        playGame();
    }

    void playGame() {
        for (int i = 0; i < racingGame.getCoin(); i++) {
            gameRule.playRound();
        }
        printWinner();
    }

    void printWinner() {
        String winnerName = gameRule.calculateWinner();
        System.out.println("최종 우승자 : " + winnerName);
    }
}
