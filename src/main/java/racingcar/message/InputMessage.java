package racingcar.message;

public enum InputMessage {
    INPUT_RACING_CARNAME("경주할 자동차 이름을 입력하세요."),
    CARS_DELIMITER(","),
    NOTE_CARS_DELIMITER("(이름은 쉼표("+CARS_DELIMITER+") 기준으로 구분)"),
    INPUT_TRYCOUNT("시도할 회수는 몇회인가요?"),;
    private final String msg;

    InputMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
