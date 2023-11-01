package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputManager {
    private static final int MAX_LENGTH = 5;
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTS_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 횟수는 숫자를 입력해야합니다";
    private static final String LENGTH_ERROR = "[ERROR] 자동차의 이름은 5자 이하만 가능합니다.";

    private List<String> carNames;
    private int attempt;

    public void inputCarNames() {
        System.out.println(CAR_NAME_PROMPT);
        carNames = parseCarNames(Console.readLine());
    }

    public void inputAttempts() {
        System.out.println(ATTEMPTS_PROMPT);
        String input = Console.readLine();
        attempt = parseAttempts(input);
    }


    public List<String> getCarNames() {
        return carNames;
    }

    public int getAttempts() {
        return attempt;
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(carName -> !carName.isEmpty())
                .collect(Collectors.toList());

        for (String carName : carNames) {
            validateUserInput(carName);
        }

        return carNames;
    }

    private int parseAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    public void validateUserInput(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
    }


}


