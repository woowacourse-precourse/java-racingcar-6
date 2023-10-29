package racingcar.util;

public enum Message {
    GET_CARS("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GET_ROUNDS("시도할 회수는 몇회인가요?"),
    TEXT_RESULT("실행 결과"),
    TEXT_WINNER("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
