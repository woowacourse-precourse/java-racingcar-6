package racingcar.constant;

public enum GuideTextConstant {

    INPUT_CAR_NAMES_GUIDE_TEXT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_EXECUTION_COUNT_GUIDE_TEXT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT_TEXT("실행 결과");

    private final String name;

    GuideTextConstant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
