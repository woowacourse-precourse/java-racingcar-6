package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void main(String[] args) {
        Application game = new Application();
        game.start();
    }

    private void start() {
        String inputNames = getUserInput("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분):");
        String[] carNames = validateCarNames(inputNames);

        int tryCount = Integer.parseInt(getUserInput("시도할 회수는 몇 회인가요?"));
        validateTryCount(tryCount);

        Race race = new Race(carNames, tryCount);
        race.startRace();
    }

    private String getUserInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}