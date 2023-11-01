package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private final Output output = new Output();
    private final static String delimter = ",";

    // 기본 으로 입력 받는 함수
    private static String getPlayerInput() {
        return Console.readLine();
    }

    // 경주할 자동차 이름을 입력받습니다.
    public List<String> getInputCarNames() {
        output.promptForCarName();
        String playerInput = getPlayerInput();
        return validateCarNames(playerInput);
    }

    // 자동차 이름을 유효한지 검사합니다.
    private List<String> validateCarNames(String input) {
        String[] carNames = input.split(delimter);

        if (carNames.length < 2) {
            Exception.invalidCarCount();
        }

        for (String carName : carNames) {
            String trimmedCarName = carName.trim();
            if (trimmedCarName.isEmpty() || trimmedCarName.length() < 1 || trimmedCarName.length() > 5) {
                Exception.invaildNameLength();
            }
        }

        List<String> uniqueCarNames = Arrays.stream(carNames)
                .map(String::trim)
                .distinct()
                .collect(Collectors.toList());

        if (uniqueCarNames.size() != carNames.length) {
            Exception.notUniqueCar();
        }

        return uniqueCarNames;
    }

    // 시도할 회수를 입력받습니다.
    public int getInputTryCount()
    {
        output.promptForTryCount();
        String playerInput = getPlayerInput();
        return validateTryCount(playerInput);
    }

    // 시도할 회수가 유효한지 검사합니다.
    public int validateTryCount(String input)
    {
        int tryCount = 0;

        try {
            tryCount = Integer.parseInt(input);

            if (tryCount <= 0) {
                Exception.invaildTryCount();
            }

            return tryCount;
        } catch (NumberFormatException e) {
            Exception.notNumber();
        }

        return tryCount;
    }
}
