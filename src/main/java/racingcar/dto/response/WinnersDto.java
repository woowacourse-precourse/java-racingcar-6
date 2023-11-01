package racingcar.dto.response;

import static racingcar.constants.Format.WINNER_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class WinnersDto {

    private final List<String> names;

    public WinnersDto(final List<Car> cars) {
        this.names = cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    public String createMessage() {
        return String.join(WINNER_DELIMITER, names);
    }

    public List<String> getNames() {
        return names;
    }
}
