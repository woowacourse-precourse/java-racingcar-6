package racingcar.constant;

public enum OutputMessage {
    EXECUTION_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자"),
    COLON(" : "),
    DISTANCE_DRIVER("-");

    private String message;

    private OutputMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
