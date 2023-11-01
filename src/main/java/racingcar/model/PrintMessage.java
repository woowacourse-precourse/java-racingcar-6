package racingcar.model;

public enum PrintMessage {
    GET_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    GET_TRY_COUNT("시도할 회수는 몇회인가요?\n"),
    RESULT("\n실행 결과\n"),
    WINNER("최종 우승자 : ");

    String message;

    PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
