package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.implementation.RacingGame;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.entireProcess();
    }
}
