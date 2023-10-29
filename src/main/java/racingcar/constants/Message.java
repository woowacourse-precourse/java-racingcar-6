package racingcar.constants;

public enum Message {
    NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_COUNT_INPUT("시도할 회수는 몇회인가요?"),
    ROUNDS_RESULT("실행 결과"),
    WINNERS("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
