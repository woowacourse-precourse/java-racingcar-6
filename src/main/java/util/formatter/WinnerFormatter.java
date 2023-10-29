package util.formatter;

import dto.WinnerDto;
import java.util.stream.Collectors;

public class WinnerFormatter {

    public String format(WinnerDto winnerDto) {
        return winnerDto.winner().stream()
                .collect(Collectors.joining(", "));
    }

}
