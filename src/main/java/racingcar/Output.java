package racingcar;

public enum Output {
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TIME("시도할 회수는 몇회인가요?"),
    RESULT("\n실행 결과"),
    WINNER("최종 우승자 : ");
    final private String text;
    Output(String text) {
        this.text = text;
    }
    String getText() {
        return text;
    }
}
