package racingcar;

import Controller.GameController;

public class Application {

    private static GameController gameController;
    public static void main(String[] args) {
        gameController = new GameController();
        int n = gameController.getUserInput();

        for(int i=0; i<n; i++) {
            gameController.decideToMove();
        }

        gameController.findWinner();
    }
}
