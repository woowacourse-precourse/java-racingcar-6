package racingcar.global.message;

public enum GameProgressMessage {

    CAR_NAMES_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_NUMBER_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    PRINT_WINNER("최종 우승자 : "),
    RACE_RESULT_MESSAGE("실행 결과");

    private final String message;

    GameProgressMessage(String message){
        this.message = message;
    };

    public void printMessage(){
        System.out.println(this.message);
    }

    public void printMessageWithNoNewLine(){
        System.out.print(this.message);
    }
}
