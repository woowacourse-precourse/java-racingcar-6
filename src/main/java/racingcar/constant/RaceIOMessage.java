package racingcar.constant;

public enum RaceIOMessage {
    CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_INPUT("시도할 횟수는 몇회인가요?"),
    RACE_RESULT("실행 결과"),
    RACE_WINNER("최종 우승자 : ");

    private final String message;

    RaceIOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
