package racingcar;

public class Output {
    private static final String MESSAGE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String MESSAGE_EXECUTION_RESULT = "실행 결과";
    private static final String MESSAGE_CAR_DISTANCE_FORMAT = "%s : %s";
    private static final String MESSAGE_FINAL_WINNER = "최종 우승자 : %s";

    public static final void printMessage(String message){
        System.out.println(message);
    }

    public static final void printCarName(){
        printMessage(MESSAGE_CAR_NAME);
    }

    public static final void printTryCount(){
        printMessage(MESSAGE_TRY_COUNT);
    }

    public static final void printExecutionResult(){
        printMessage(MESSAGE_EXECUTION_RESULT);
    }

    public static final void printCarDistance(String name, String distance){
        System.out.printf((MESSAGE_CAR_DISTANCE_FORMAT) + "%n", name, distance);
    }

    public static final void printFinalWinner(String winner){
        System.out.printf((MESSAGE_FINAL_WINNER) + "%n", winner);
    }
}
