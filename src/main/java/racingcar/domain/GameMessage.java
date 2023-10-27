package racingcar.domain;

public enum GameMessage {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    WINNER_MESSAGE("최종 우승자 : ");

    String message;
    GameMessage(String message) {
        this.message = message;
    }
}
