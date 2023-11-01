package constants;

public enum MessageType {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT("시도할 회수는 몇회인가요?"),
    PROGRESS_RESULT("실행 결과"),
    GAME_RESULT("최종 우승자 : {우승 자동차}");

    private String message;

    MessageType(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
