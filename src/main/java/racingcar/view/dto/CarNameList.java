package racingcar.view.dto;

import java.util.List;
import java.util.stream.Stream;

public record CarNameList(
        List<String> carNames
) {

    public CarNameList(String[] carNames) {
        this(
                List.of(carNames)
        );
    }

    public Stream<String> stream() {
        return carNames.stream();
    }
}
