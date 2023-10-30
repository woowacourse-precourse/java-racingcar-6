package racingcar.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Winners;

public class CarWinnersDto {
    private final List<String> winnerNames;

    private CarWinnersDto(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public static CarWinnersDto from(Winners winners) {
        List<String> winnerNames = getWinnerNames(winners);
        return new CarWinnersDto(winnerNames);
    }

    private static List<String> getWinnerNames(Winners winners) {
        List<Car> carWinners = winners.getCars();
        return carWinners.stream()
                .map(Car::getName)
                .map(CarName::getName)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
