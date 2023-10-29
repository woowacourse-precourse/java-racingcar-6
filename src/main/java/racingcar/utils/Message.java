package racingcar.utils;

public enum Message {
    StartGameMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    AttempNumMessage("시도할 회수는 몇회인가요?"),
    ResultMessage("실행결과"),
    ProgressBar("-"),
    WINNERPRINTMESSAGE("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
