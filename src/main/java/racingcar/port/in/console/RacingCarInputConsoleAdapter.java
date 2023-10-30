package racingcar.port.in.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.port.in.RacingCarInputPort;

import java.util.List;

public class RacingCarInputConsoleAdapter implements RacingCarInputPort {
    @Override
    public List<String> getCarNames() {
        String input = Console.readLine();

        List<String> carNames = splitCarNames(input);
        validateCarNames(carNames);

        return carNames;
    }

    @Override
    public int getTryCount() {
        String input = Console.readLine();

        validateIsNumber(input);
        validateIsValidTryCount(input);

        return Integer.parseInt(input);
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
    }

    private void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateIsValidTryCount(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상이어야 합니다.");
        }
    }
}
