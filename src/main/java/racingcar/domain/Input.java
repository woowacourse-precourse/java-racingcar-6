package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Input {

    private static final int MINIMUM_GAME_COUNT = 1;
    private static final String COMMA = ",";
    private static final String GAME_COUNT_EXCEPTION_MESSAGE = "게임 가능 횟수는 1 이상 입니다.";
    private static final String DUPLICATION_EXCEPTION_MESSAGE = "중복된 이름이 있습니다.";

    private String userInput;

    public CarNames getCarNames() {
        userInput = Console.readLine();
        List<CarName> carNames = Arrays.stream(userInput.split(COMMA))
                .map(name -> new CarName(name.trim()))
                .collect(Collectors.toList());
        validateDuplication(carNames);
        return new CarNames(carNames);
    }

    public GameCount getGameCount() {
        userInput = Console.readLine();
        validateGameCountNubmer(userInput);
        GameCount gameCount = new GameCount(userInput);
        closeConsole();
        return gameCount;
    }

    private void closeConsole() {
        Console.close();
    }

    private void validateGameCountNubmer(String userInput) {
        if (Integer.parseInt(userInput) < MINIMUM_GAME_COUNT) {
            throw new IllegalArgumentException(GAME_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplication(List<CarName> carNames) {
        Set<CarName> carNamesToSet = new HashSet<>(carNames);
        if(carNamesToSet.size()!= carNames.size()){
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION_MESSAGE);
        }
    }
}
