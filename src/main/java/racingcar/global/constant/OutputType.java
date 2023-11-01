package racingcar.global.constant;

public enum OutputType {

    INPUT_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_GAMES("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : "),
    SPACE(" "),
    NEXT_LINE("\n"),
    EXCEPTION("잘못된 입력입니다. 애플리케이션을 종료합니다.");

    private final String comment;

    OutputType(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
