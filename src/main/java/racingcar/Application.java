package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String carInput = Console.readLine();
        List<String> cars = Arrays.stream(carInput.split(",")).toList();
        validateCarName(cars);

        String attemptInput = Console.readLine();
        validateAttemptInput(attemptInput);
        int attempt = Integer.parseInt(attemptInput);
    }

    private static void validateAttemptInput(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
    }

    public static void validateCarName(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        for (String carName : cars) {
            if (carName.isBlank() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }
}
