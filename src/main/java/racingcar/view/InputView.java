package racingcar.view;

import racingcar.view.reader.InputReader;

public class InputView {
    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";

    private final InputReader inputReader;

    public InputView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public String readCarNames() {
        System.out.println(ENTER_CAR_NAMES);
        return inputReader.readLine();
    }

    public int readAttemptCount() {
        System.out.println(ENTER_ATTEMPT_COUNT);
        int attemptCount = Integer.parseInt(inputReader.readLine());
        validateAttemptCount(attemptCount);
        return attemptCount;
    }

    private void validateAttemptCount(int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
        }
    }
}
