package racingcar.view.constant;

public enum Prompt implements Message {
    CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_MOVE_INPUT("시도할 회수는 몇회인가요?"),
    RACE_RESULT("\n실행 결과");

    private final String prompt;

    Prompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public String getMessage() {
        return prompt;
    }
}
