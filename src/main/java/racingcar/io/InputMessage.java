package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.Scanner;

public class InputMessage {

    private final String RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String NUMBER_OF_TRIES = "시도할 회수는 몇회인가요?";

    public Integer userInputNumberOfAttempts() {
        System.out.println(NUMBER_OF_TRIES);
        String inputNumberAttempts = readLine();
        if (inputNumberAttempts == null) {
            return null;
        }
        return Integer.valueOf(inputNumberAttempts);
    }

    public List<String> userInputCarName() {
        System.out.println(RACING_CAR_NAMES);
        String inputCarNames = readLine();
        if (inputCarNames == null) {
            return null;
        }

        List<String> carNames = List.of(inputCarNames.split(","));
        return carNames;
    }
}
