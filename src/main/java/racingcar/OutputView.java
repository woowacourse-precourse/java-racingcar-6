package racingcar;

import java.util.List;

public class OutputView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String DELIMITER = " : ";
    private static final String DASH = "-";
    private static final int DEFAULT_VALUE = 0;

    public void printResultMessage() {
        System.out.println("\n" + EXECUTE_RESULT);
    }
    public void printRoundResult(RoundResult roundResult) {
        List<CarDto> results = roundResult.getResult();
        for (CarDto result : results) {
            String format = getOutputFormat(result.getName(), result.getPosition());
            System.out.println(format);
        }
        System.out.println();
    }

    private String getOutputFormat(String name, int position) {
        return name + DELIMITER + DASH.repeat(Math.max(DEFAULT_VALUE, position));
    }
}