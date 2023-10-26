package racingcar.util;

public enum MessageUtil {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    GAME_PLAYING_RESULT_MESSAGE("실행 결과"),
    CAR_POSITION_MESSAGE("%s : "),
    FINAL_WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    MessageUtil(String message){
        this.message = message;
    }

    public void messagePrint(){
        System.out.print(this.message);
    }

    public void messagePrintln(){
        System.out.println(this.message);
    }
}
