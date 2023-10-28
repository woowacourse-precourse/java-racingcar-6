package racingcar.constant;

public enum OutputConstant {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"), HOW_MANY_TIME("시도할 회수는 몇회인가요?"),
    GAME_START("실행 결과");
    final String output;

    OutputConstant(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
