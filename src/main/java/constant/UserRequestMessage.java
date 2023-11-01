package constant;

public enum UserRequestMessage {
    CAR_NAME_REQUEST_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    Repeat_REQUEST_MESSAGE("시도할 회수는 몇회인가요?");
    private final String message;

    UserRequestMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
