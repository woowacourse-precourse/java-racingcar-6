package message;

public enum GameMessage {

    start("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    count("시도할 회수는 몇회인가요?"),
    result("실행 결과"),
    winner("최종 우승자"),
    equal(" : "),
    bar("-"),
    nameError("자동차의 이름은 5자리 이내입니다."),
    countError("회수는 음수가 아닌 정수로 입력해주세요."),
    REGEX("[0-9]+"),
    newLine("\n");

    private final String message;

    GameMessage(final String message) {
        this.message = message;
    }

    public String getMessage() { return message; }

}
