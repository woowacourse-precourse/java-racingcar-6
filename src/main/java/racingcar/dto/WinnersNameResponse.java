package racingcar.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class WinnersNameResponse {

    private List<String> names;

    private WinnersNameResponse(List<String> names) {
        this.names = names;
    }

    public static WinnersNameResponse create(List<Car> winnersCar) {
        return winnersCar.stream()
                .map(Car::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinnersNameResponse::new));
    }

    public List<String> getWinnersName() {
        return Collections.unmodifiableList(this.names);
    }
}
