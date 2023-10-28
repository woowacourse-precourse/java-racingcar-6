package racingcar.view;

public class OutputView {
    private static final String FIRST_SHOWN_RESULT_TEXT = "실행 결과\n";
    private static final String TRIAL_NUMBER_INPUT_TEXT = "시도할 회수는 몇회인가요?\n";
    private static final String CAR_NAME_INPUT_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String FIRST_SHOWN_WINNER_TEXT = "최종 우승자 : ";

    public static void printFirstShownWinnerText() {
        System.out.print(FIRST_SHOWN_WINNER_TEXT);
    }

    public static void printMovingDistanceOnTurnResult(int movingDistance) {
        for (int moved = 0; moved < movingDistance; moved++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printCarNameOnTurnResult(String carName) {
        System.out.print(carName + " : ");
    }

    public static void printFirstShownResultText() {
        System.out.print(FIRST_SHOWN_RESULT_TEXT);
    }

    public static void printTrialNumberInputText() {
        System.out.print(TRIAL_NUMBER_INPUT_TEXT);
    }

    public static void printCarNameInputText() {
        System.out.print(CAR_NAME_INPUT_TEXT);
    }
}
