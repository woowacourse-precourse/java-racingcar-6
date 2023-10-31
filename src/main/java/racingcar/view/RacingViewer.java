package racingcar.view;

public class RacingViewer {
    private final static String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String WINNER_MESSAGE = "최종 우승자 : ";

    public void showCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public void showTryCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }

    public void showResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE);
    }

    public void showNewLine() {
        System.out.println();
    }

    public void showCurrentPosition(String currentResult) {
        System.out.println(currentResult);
    }

    public void showWinnerMessage(String winnerList) {
        System.out.println(WINNER_MESSAGE + winnerList);
    }
}
