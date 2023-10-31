package racingcar.view;

public enum Message {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACE_COUNT("시도할 회수는 몇회인가요?"),
    RACE_START("\n실행 결과"),
    WINNER("최종 우승자 : ");

    String message;

    Message(String message) {
        this.message = message;
    }

    protected void println() {
        System.out.println(message);
    }

    protected void print() {
        System.out.print(message);
    }
}
