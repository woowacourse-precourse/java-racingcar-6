package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.CarRacingGame;

import java.util.Arrays;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.start();
        carRacingGame.printAllTry(carRacingGame.getCars());
        carRacingGame.printWinner(carRacingGame.getCars());
    }
}
