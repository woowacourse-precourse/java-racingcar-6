package racingcar.view;

public class OutputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String SHOW_RESULT_STRING = "실행 결과";
    private static final String SHOW_WINNER_STRING = "실행 결과";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printTryMessage() {
        System.out.println(TRY_MESSAGE);
    }

    public static void printShowResultString() {
        System.out.println(SHOW_RESULT_STRING);
    }

    public static void printShowWinnerString() {
        System.out.print(SHOW_WINNER_STRING);
    }

//    public static void printFinalWinnerBy(String[] winnerCarNames) {
//        System.out.println("최종 우승자 : " + String.join(", ", winnerCarNames));
//    }
}