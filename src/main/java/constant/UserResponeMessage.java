package constant;

public enum UserResponeMessage {
    EXECUTION_RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자 : ");
    private final String message;

    UserResponeMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
