package util.formatter;

import dto.WinnerDto;

public class WinnerFormatter {

    private static final String WINNER_PREFIX = "최종 우승자 : ";

    private static final String DELIMITER = ", ";
    public static String format(WinnerDto winnerDto) {
        return WINNER_PREFIX + String.join(DELIMITER, winnerDto.winner());
    }

}