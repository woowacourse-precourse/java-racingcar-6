package racingcar.view;

public final class OutputMessage {
    private static final String OUTPUT_RESULT_TEXT_MESSAGE = "실행 결과";
    private static final String OUTPUT_FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    public static void outputResultText() {
        System.out.println(OUTPUT_RESULT_TEXT_MESSAGE);
    }
    public static void outputFinalWinner() {
        System.out.print(OUTPUT_FINAL_WINNER_MESSAGE);
    }
}
