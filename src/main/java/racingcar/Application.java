package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceGame raceGame = new RaceGame();
        raceGame.run();
        // return Scanner resource
        Console.close();
    }
}