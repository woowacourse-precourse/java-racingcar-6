package racingcar.view;

public enum ViewConstants {
    INPUT_CARS("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"),
    INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?"),
    OUTPUT_EXECUTION_START("실행 결과"),
    OUTPUT_CAR_STATUS_FORMAT("%s : %s"),
    OUTPUT_FINAL_WINNER("최종 우승자 : ");

    private final String message;

    ViewConstants(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
