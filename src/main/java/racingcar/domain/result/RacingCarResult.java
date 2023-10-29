package racingcar.domain.result;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record RacingCarResult(String name, Integer location) {

    private static final String MOVE_SYMBOL = "-";
    private static final String COLON = " : ";

    public String getResultMessage() {
        return name + COLON + Stream.generate(() -> MOVE_SYMBOL).limit(location).collect(Collectors.joining());
    }
}
