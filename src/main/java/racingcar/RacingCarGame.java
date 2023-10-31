package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] items = readLine().split(",");
        for (String item : items) {
            racingCars.add(new RacingCar(item));
        }
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