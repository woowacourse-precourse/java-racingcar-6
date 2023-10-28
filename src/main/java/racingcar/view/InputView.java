package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private List<String> splitCarNames(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void carNameValidition(List<String> carNameList) throws IllegalArgumentException {
        carNameList.stream()
                .filter(carName -> carName.length() > 5)
                .findFirst()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
                });
    }

    public List<String> inputCarNames() {
        String userInput = Console.readLine();
        List<String> carNameList = splitCarNames(userInput);
        carNameValidition(carNameList);
        return carNameList;
    }

    public int inputTryCount() {
        return 0;
    }
}
