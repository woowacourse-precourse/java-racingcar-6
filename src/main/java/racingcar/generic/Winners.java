package racingcar.generic;

import java.util.List;
import java.util.stream.Stream;

public record Winners(List<String> winners) {

    public Stream<String> stream() {
        return winners.stream();
    }

}
