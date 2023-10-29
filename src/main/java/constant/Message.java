package constant;

public enum Message {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    INPUT_ROUND_NUMBER("시도할 회수는 몇회인가요?\n"),
    OUTPUT_RUN_RESULT("\n실행 결과\n"),
    OUTPUT_CAR_POSITION("%s : %s\n"),
    OUTPUT_FINAL_WINNER("최종 우승자 : %s"),
    OUTPUT_NEWLINE("\n"),
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
