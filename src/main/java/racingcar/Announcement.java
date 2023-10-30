package racingcar;

public enum Announcement {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    WINNER("최종 우승자 : ");

    private final String value;

    Announcement(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
