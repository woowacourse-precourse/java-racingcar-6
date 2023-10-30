package racingcar.view;

public class OutputView {
    private final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RESULT_GUIDE_MESSAGE = "\n" + "실행 결과";
    private final static String WINNER_GUIDE_MESSAGE = "최종 우승자 : ";

    public void displayCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void displayTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void displayResultGuideMessage() {
        System.out.println(RESULT_GUIDE_MESSAGE);
    }

    public void displayLocation(String locationAnnouncement) {
        System.out.print(locationAnnouncement);
    }

    public void displayWinner(String winner) {
        System.out.print(WINNER_GUIDE_MESSAGE + winner);
    }

    public void displayNewLine() {
        System.out.println();
    }
}
