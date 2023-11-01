package racingcar.view.output;

public abstract class OutputView {
    private static final String STRING_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String STRING_INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String STRING_EXECUTION_RESULT = "실행 결과";
    private static final String STRING_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String STRING_DELIMITER_BETWEEN_NAME_AND_DISTANCE = " : ";

    protected abstract void print(final String text);

    protected abstract void println(final String text);

    public void printExecutionResult() {
        println(STRING_EXECUTION_RESULT);
    }

    public void printInputTryCountMessage() {
        println(STRING_INPUT_TRY_COUNT);
    }

    public void printInputCarNameMessage() {
        println(STRING_INPUT_CAR_NAME);
    }

    public void printNewLine() {
        println("");
    }

    public void printWinnersFromCarList(final String winners) {
        print(STRING_WINNER_MESSAGE);
        println(winners);
    }

    public void printCarNameAndDistanceString(final String name, final String distanceString) {
        print(name);
        print(STRING_DELIMITER_BETWEEN_NAME_AND_DISTANCE);
        print(distanceString);
        printNewLine();
    }
}
