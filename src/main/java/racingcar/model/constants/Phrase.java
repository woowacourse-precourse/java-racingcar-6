package racingcar.model.constants;

public enum Phrase {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GAME_TRIAL("시도할 횟수는 몇회인가요?"),
    GAME_RESULT("\n실행 결과");

    private final String phrase;

    Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
