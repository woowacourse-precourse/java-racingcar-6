package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RacingGame {

    private void inputCarsInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        getCarNames();
    }

    private void getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            validateCarName(carName);
        }
        validateDuplicate(carNames);
    }

    private void validateCarName(String carName) {
        validateLength(carName);
        validateBlank(carName);
    }

    private void validateLength(String carName) {
        if (!isValidLength(carName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength(String carName) {
        return carName.length() >= 1 && carName.length() <= 5;
    }

    private void validateBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>(Arrays.asList(carNames));

        if (uniqueCarNames.size() != carNames.length) {
            throw new IllegalArgumentException();
        }
    }

    private void inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
