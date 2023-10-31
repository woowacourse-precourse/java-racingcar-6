package racingcar.domain;

import java.util.List;

public record Winners(List<String> winners) {

    public static Winners from(List<String> winners) {
        return new Winners(winners);
    }
}
