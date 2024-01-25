package racingcar.constants.message;

import static racingcar.model.Cars.DIVISION;

public enum ProgressMessage {
    INPUT_RACING_CAR_NAMES(String.format("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)", DIVISION)),
    INPUT_ATTEMPT_COUNT("시도할 횟수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    FINAL_WINNERS("최종 우승자");
    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
