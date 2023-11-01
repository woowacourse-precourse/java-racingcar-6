package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String DELIMITER_COLON = " : ";
    private static final String DASH = "-";
    private static final int DEFAULT_VALUE = 0;
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String DELIMITER_COMMA = ", ";
    private static final String NEW_LINE = "\n";

    public void printResultMessage() {
        System.out.println(NEW_LINE + EXECUTE_RESULT);
    }

    public void printRoundResult(RoundResult roundResult) {
        List<CarDto> results = roundResult.getResult();
        for (CarDto result : results) {
            String format = getRoundResultFormat(result.getName(), result.getPosition());
            System.out.println(format);
        }
        System.out.println();
    }

    public void printWinners(List<CarDto> cars) {
        String winners = getWinnersFormat(cars);
        System.out.println(FINAL_WINNER + DELIMITER_COLON + winners);
    }

    private String getWinnersFormat(List<CarDto> cars) {
        return cars.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(DELIMITER_COMMA));
    }

    private String getRoundResultFormat(String name, int position) {
        return name + DELIMITER_COLON + DASH.repeat(Math.max(DEFAULT_VALUE, position));
    }
}