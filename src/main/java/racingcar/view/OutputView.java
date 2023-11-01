package racingcar.view;

public class OutputView {
    private static final String RESULT_ROUND_MESSAGE = "\n" + "실행 결과" + "\n";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final StringBuilder stringBuilder = new StringBuilder();

    public void printResultMassage() {
        stringBuilder.append(RESULT_ROUND_MESSAGE);
    }

    public void printRoundGameResult(StringBuilder eachResultBuilder) {
        System.out.println(eachResultBuilder);
        stringBuilder.setLength(0);
    }

}
