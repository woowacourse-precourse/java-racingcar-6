package racingcar.view.constant;

public enum SystemMessage {

    READ_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    READ_TRY_COUNT("시도할 회수는 몇회인가요?"),
    RACE_STATUS("\n실행 결과"),
    RACE_WINNERS("최종 우승자 : %s");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
