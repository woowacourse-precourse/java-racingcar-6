package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.console.ConsoleInput;
import racingcar.interceptors.*;
import racingcar.model.Car;
import racingcar.service.RacingGame;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }
}
