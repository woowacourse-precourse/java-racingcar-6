package racingcar.dto;

import java.util.List;
import racingcar.domain.Cars;

public record WinnerNames(List<String> names) {

    public static WinnerNames from(final Cars cars) {
        return new WinnerNames(cars.findAllWinnerNames());
    }

    @Override
    public String toString() {
        return String.join(",", names);
    }
}
