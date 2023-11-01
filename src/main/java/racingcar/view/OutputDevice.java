package racingcar.view;

public final class OutputDevice {
    private final static String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String WINNER_MESSAGE = "최종 우승자 : ";

    private OutputDevice() {
    }

    public static void printInputNamesMessage(){
        System.out.println(INPUT_NAMES_MESSAGE);
    }

    public static void printInputAttemptCountMessage(){
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    public static void printResultMessage(String resultMessage) {
        System.out.println("\n" + RESULT_MESSAGE);
        System.out.println(resultMessage);
    }

    public static void printWinnerMessage(String winnerMessage){
        System.out.println("\n" + WINNER_MESSAGE + winnerMessage);
    }

}
