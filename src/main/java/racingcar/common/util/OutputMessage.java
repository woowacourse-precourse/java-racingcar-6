package racingcar.common.util;

public enum OutputMessage {
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_NUMBER("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    FINISH("최종 우승자 : "),
    VALIDATE_NOT_NUMBER("입력된 문자열에 숫자 이외의 문자가 포함되어 있습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
