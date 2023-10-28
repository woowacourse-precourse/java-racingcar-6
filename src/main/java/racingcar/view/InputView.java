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

    private void negativeValidaition(int tryCount) throws IllegalArgumentException {
        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 0이상의 정수여야 합니다.");
        }
    }

    private void tryCountValidaition(String userInput) throws IllegalArgumentException {
        try {
            int tryCount = Integer.parseInt(userInput);
            negativeValidaition(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 0이상의 정수여야 합니다.");
        }
    }

    public int inputTryCount() {
        String userInput = Console.readLine();
        tryCountValidaition(userInput);
        return Integer.parseInt(userInput);
    }
}
