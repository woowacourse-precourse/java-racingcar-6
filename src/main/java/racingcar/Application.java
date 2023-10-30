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


    private String[] validateCarNames(String inputNames) {
        String[] carNames = inputNames.split(",");
        Set<String> uniqueCarNames = new HashSet<>();

        for (String name : carNames) {
            String trimmedName = name.trim();
            validateCarNameLength(trimmedName);
            uniqueCarNames.add(trimmedName);
        }

        if (uniqueCarNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        return uniqueCarNames.toArray(new String[0]);
    }
    private void validateCarNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1에서 5자 사이여야 합니다.");
        }
    }

}