package racingcar.model;

public enum Messages {
    LENGTH_EXCEPTION("자동차의 이름은 5자 이하여야 합니다."),
    NON_INPUT_EXCEPTION("자동차의 이름을 입력해주세요."),
    DUPLICATION_EXCEPTION("중복된 자동차가 있습니다."),
    NON_CHARACTER_EXCEPTION("자동차의 이름은 알파벳으로만 구성되야 합니다."),
    NOT_ONE_TO_NINE_EXCEPTION("시도 횟수는 1~9까지의 숫자를 입력해주세요."),
    NON_NUMERIC_EXCEPTION("숫자만을 입력해주십시오."),
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_NUMBER_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("\n실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}