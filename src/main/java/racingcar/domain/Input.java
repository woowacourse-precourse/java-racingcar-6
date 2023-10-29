package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Input {

    private String userInput;

    public List<CarName> getCarNames() {
        userInput = Console.readLine();
        List<CarName> carNames = Arrays.stream(userInput.split(","))
                .map(name -> new CarName(name.trim()))
                .collect(Collectors.toList());
        validateDuplication(carNames);
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

    private void validateDuplication(List<CarName> carNames) {
        Set<CarName> carNamesToSet = new HashSet<>();
        carNamesToSet.addAll(carNames);
        if(carNamesToSet.size()!= carNames.size()){
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
