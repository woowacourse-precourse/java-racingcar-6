package util.formatter;

import dto.RoundResultDto;
import java.util.List;

public class RoundResultFormatter {

    public String format(List<RoundResultDto> carResults) {
        StringBuilder resultBuilder = new StringBuilder();

        for (RoundResultDto result : carResults) {
            formatSingleResult(resultBuilder, result);
            resultBuilder.append("\n");
        }

        return resultBuilder.toString();
    }

    private static void formatSingleResult(StringBuilder builder, RoundResultDto result) {
        builder.append(result.carName())
                .append(" : ")
                .append(generateDash(result.carLocation()));
    }

    private static String generateDash(int location) {
        StringBuilder dashBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            dashBuilder.append("-");
        }
        return dashBuilder.toString();
    }
}