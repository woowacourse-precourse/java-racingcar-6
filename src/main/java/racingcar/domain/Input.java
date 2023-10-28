package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;

    private String userInput;

    public List<String> getCarNames() {
        userInput = Console.readLine();
        List<String> carNames = Arrays.asList(userInput.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    public int getGameCount() {
        userInput = Console.readLine();
        int gameCount = Integer.parseInt(userInput);
        validateGameCountNubmer(gameCount);
        return gameCount;
    }

    private void validateGameCountNubmer(int gameCount) {
        if (gameCount < 1) {
            throw new IllegalArgumentException("게임 가능 횟수는 1 이상 입니다.");
        }
    }

    private void validateCarNames(List<String> carNames) {
        validateNameLength(carNames);
        validateDuplication(carNames);
    }

    private void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (!(name.length() <= CAR_NAME_MAX_LENGTH && name.length() >= CAR_NAME_MIN_LENGTH)) {
                throw new IllegalArgumentException("이름은 1~5자 길이로 입력해주세요.");
            }
        }
    }

    private void validateDuplication(List<String> carNames) {
        Set<String> carNamesToSet = new HashSet<>(carNames);
        if(carNamesToSet.size()!= carNames.size()){
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
