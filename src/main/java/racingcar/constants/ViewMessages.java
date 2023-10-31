package racingcar.constants;

import static racingcar.constants.Delimiters.CAR_NAME_DELIMITER_DESCRIPTION;

public enum ViewMessages {

    REQUEST_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + CAR_NAME_DELIMITER_DESCRIPTION + ") 기준으로 구분)"),
    REQUEST_RACE_ROUNDS("시도할 회수는 몇회인가요?"),
    RACE_WINNERS("최종 우승자"),
    RACE_RESULT("실행 결과");

    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

