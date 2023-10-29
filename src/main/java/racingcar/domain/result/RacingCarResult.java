package racingcar.domain.result;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public record RacingCarResult(String name, Integer location) {

    public String getResult() {
        return name + " : " + Stream.generate(() -> "-").limit(location).collect(Collectors.joining());
    }
}
