package racingcar;

public enum Message {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ROUND_COUNT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT_TITLE("실행 결과"),
    WINNER("최종 우승자 : "),

    NAME_LENGTH_ERROR("자동차 이름은 5자 이하까지만 가능합니다.");


    private String message;

    Message(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}