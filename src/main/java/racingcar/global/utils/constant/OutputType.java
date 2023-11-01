package racingcar.global.utils.constant;

public enum OutputType {

    OUTPUT_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    OUTPUT_NUMBER_OF_ATTEMPTS("시도할 회수는 몇회인가요?"),
    OUTPUT_RESULT("실행 결과"),
    OUTPUT_WINNER("최종 우승자 : "),
    EMPTY(""),
    EXCEPTION("잘못된 입력입니다. 애플리케이션을 종료합니다.");

    private final String comment;

    OutputType(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
