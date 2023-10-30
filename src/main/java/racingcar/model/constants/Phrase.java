package racingcar.model.constants;

public enum Phrase {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GAME_TRIAL("시도할 횟수는 몇회인가요?"),
    GAME_RESULT("\n실행 결과"),
    GAME_WINNER("최종 우승자 : "),

    DELIMITER(","),
    SEPARATOR(" : "),
    MOVEMENT("-");

    private final String message;

    Phrase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
