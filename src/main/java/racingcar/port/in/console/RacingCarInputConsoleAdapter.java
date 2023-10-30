package racingcar.port.in.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.port.in.RacingCarInputPort;

import java.util.List;

public class RacingCarInputConsoleAdapter implements RacingCarInputPort {
    @Override
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> carNames = splitCarNames(input);
        validateCarNames(carNames);

        return carNames;
    }

    @Override
    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
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
