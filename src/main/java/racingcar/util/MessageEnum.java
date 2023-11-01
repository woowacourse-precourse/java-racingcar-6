package racingcar.util;


public enum MessageEnum {

    INPUT_START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_MESSAGE("시도할 회수는 몇회인가요?"),
    PLAY_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    MessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
