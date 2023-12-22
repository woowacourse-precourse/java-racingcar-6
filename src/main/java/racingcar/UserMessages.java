package racingcar;

public enum UserMessages {
    ASK_FOR_DRIVER_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_FOR_NUMBER_OF_RACES("시도할 회수는 몇회인가요?"),
    INVALID_NUMBER_INPUT("유효한 숫자를 입력하세요."),
    WINNER_ANNOUNCEMENT("최종 우승자 : "),
    RACE_RESULT("실행 결과");

    private final String content;

    UserMessages(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    @Override
    public String toString(){
        return this.content;
    }

}
