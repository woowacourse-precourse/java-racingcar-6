package racingcar.view;

public enum UITexts {
    ASK_FOR_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    HOW_MANY_TRIES("시도할 회수는 몇회인가요?"),
    RACING_RESULT("실행 결과");

    private final String text;

    UITexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
