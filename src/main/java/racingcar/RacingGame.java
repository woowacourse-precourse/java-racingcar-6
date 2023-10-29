package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    Integer targetAttempts;
    private static final int MIN_TARGET_ATTEMPS = 0;

    public RacingGame() {
        targetAttempts = MIN_TARGET_ATTEMPS;
    }

    public void start() throws IllegalArgumentException {
        printCarNameInputMessages();
        List<String> carNames = getCarNames();

        printTargetAttemptsInputMessage();
        targetAttempts = getTargetAttempts();
        validateTargetAttempts(targetAttempts);

    }

    private void printCarNameInputMessages() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private List<String> getCarNames() throws IllegalArgumentException {
        String strNames = Console.readLine();
        if (Objects.isNull(strNames)) {
            throw new IllegalArgumentException("자동차들의 이름은 NULL이 될 수 없습니다.");
        }
        return Arrays.asList(strNames.split(","));
    }

    private int getTargetAttempts() throws IllegalArgumentException {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 올바른 숫자 형식 값이 아닙니다.");
        }
    }

    private void printTargetAttemptsInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void validateTargetAttempts(final int targetAttempts) throws IllegalArgumentException {
        if (targetAttempts < MIN_TARGET_ATTEMPS) {
            throw new IllegalArgumentException("시도 횟수는 최소 " + MIN_TARGET_ATTEMPS + "이상이어야 합니다");
        }
    }
}
