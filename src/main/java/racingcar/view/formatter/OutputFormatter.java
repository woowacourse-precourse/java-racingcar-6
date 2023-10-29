package racingcar.view.formatter;

import racingcar.dto.CarDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OutputFormatter {

    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String DELIMITER_COMMA = ",";

    private static final int START_POSITION = 0;


    public static String makeWinner(List<CarDto> winners) {
        return winners.stream()
                .map(c -> c.name())
                .collect(Collectors.joining(DELIMITER_COMMA + SPACE, WINNER_MESSAGE, EMPTY_STRING));
    }

    public static String makeRoundResult(List<CarDto> players) {
        return players.stream()
                .map(c -> makeOnePlayerResult(c))
                .collect(Collectors.joining());
    }

    private static String makeOnePlayerResult(CarDto carDto) {
        return carDto.name() + " : " + makeDash(carDto.position());
    }

    private static String makeDash(int position) {
        return IntStream.range(START_POSITION, position)
                .mapToObj(i -> DASH)
                .collect(Collectors.joining(EMPTY_STRING));
    }

}
