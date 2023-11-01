package racingcar.view;

public class OutputView {
    private static final String OUTPUT_MESSAGE_OF_GAME_WINNER = "최종 우승자 : ";
    private static final String INPUT_MESSAGE_OF_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MESSAGE_OF_TOTAL_ROUND = "시도할 회수는 몇회인가요?";
    public static final String OUTPUT_MESSAGE_OF_RESULT = "실행 결과";

    public static void printBlankLine(int blankLineNumber) {
        System.out.print("\n".repeat(Math.max(0, blankLineNumber)));
    }

    public static void printOutputMessage(String message) {
        System.out.println(message);
    }

    public static void printInputMessageOfCarInfo() {
        System.out.println(INPUT_MESSAGE_OF_CAR_NAMES);
    }

    public static void printInputMessageOfTotalRound() {
        System.out.println(INPUT_MESSAGE_OF_TOTAL_ROUND);
    }

    public static void printOutputMessageResult() {
        System.out.println(OUTPUT_MESSAGE_OF_RESULT);
    }

    public static void printOutputMessageOfGameWinner() {
        System.out.print(OUTPUT_MESSAGE_OF_GAME_WINNER);
    }
}
