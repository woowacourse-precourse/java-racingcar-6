package racingcar;

import java.util.ArrayList;

public class RacingCarGame {
    int gameCount = 0;
    ArrayList<RacingCar> racingCars = new ArrayList<>();

    void startGame() {
        setPlayers();
        setGameCount();
        for (int i = 0; i < gameCount; i++) {
            playGame();
            printResult();
        }
        printWinners();
    }

    void setPlayers() {
    }

    void setGameCount() {
    }

    void playGame() {
    }

    void printResult() {
    }

    void printWinners() {
    }
}