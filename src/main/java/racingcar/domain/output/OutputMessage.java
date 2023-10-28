package racingcar.domain.output;

public enum OutputMessage {

    PLEASE_ENTER_CAR_NAME("경주할 %s 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    HOW_MANY_TIME("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : %s"),
    PROGRESS_RESULT("%s : %s");

    final String message;

    OutputMessage(String message){
        this.message = message;
    }
}
