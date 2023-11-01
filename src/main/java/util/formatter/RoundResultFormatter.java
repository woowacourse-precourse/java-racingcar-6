package util.formatter;

import dto.RoundResultDto;
import java.util.List;

public class RoundResultFormatter {

    private static final String RESULT_DELIMITER = " : ";

    public static String format(List<RoundResultDto> carResults) {
        StringBuilder resultBuilder = new StringBuilder();

        for (RoundResultDto result : carResults) {
            formatSingleResult(resultBuilder, result);
            resultBuilder.append("\n");
        }

        return resultBuilder.toString();
    }

    private static void formatSingleResult(StringBuilder builder, RoundResultDto result) {
        builder.append(result.carName())
                .append(RESULT_DELIMITER)
                .append(generateDash(result.carLocation()));
    }

    private static String generateDash(int location) {
        return "-".repeat(location);
    }
}