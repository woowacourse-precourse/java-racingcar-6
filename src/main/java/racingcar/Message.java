package racingcar;

public enum Message {
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    END("최종 우승자 : "),
    COUNT("시도할 회수는 몇회인가요?");


    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }


}
