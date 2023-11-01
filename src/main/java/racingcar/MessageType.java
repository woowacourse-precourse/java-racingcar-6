package racingcar;

public enum MessageType {
    CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자");
    
    private final String message;
    
    MessageType(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
