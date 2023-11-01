package racingcar.util;

public enum ProgramMessage {
    CAR_NAME_INPUT_GUIDE_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_NUM_INPUT_GUIDE_MESSAGE("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT_NOTIFICATION_MESSAGE("\n실행 결과"),
    FINAL_WINNER_NOTIFICATION_MESSAGE("최종 우승자 : "),
    NEXT_LINE("\n");


    String message;

    ProgramMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
