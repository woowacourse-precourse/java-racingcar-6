package racingcar.common;

/**
 * @Enum : 자동차 경주의 출력 메세지 타입
 */
public enum MessageType {

    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ATTEMPTS("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    COLON(" : "),
    ADVANCE("-"),
    FINAL_WINNER("최종 우승자 : "),
    COMMA(", "),
    LINE_BREAK("");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
