package util.formatter;

import dto.WinnerDto;
import java.util.stream.Collectors;

public class WinnerFormatter {

    private static final String WINNER_PREFIX = "최종 우승자: ";

    public String format(WinnerDto winnerDto) {
        StringBuilder builder = new StringBuilder();

        builder.append(WINNER_PREFIX)
                .append(winnerDto.winner().stream().collect(Collectors.joining(", ")));

        return builder.toString();
    }

}