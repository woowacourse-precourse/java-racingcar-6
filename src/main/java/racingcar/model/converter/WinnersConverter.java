package racingcar.model.converter;

import racingcar.model.Cars;
import racingcar.model.dto.WinnerResponse;
import java.util.List;

public class WinnersConverter {

    private WinnersConverter() {
    }

    public static List<WinnerResponse> fromEntity(final Cars cars) {
        int winnerScore = cars.calculateWinnersPosition();

        return CarsConverter.fromEntity(cars)
                .stream()
                .filter(response -> response.getPosition() == winnerScore)
                .map(response -> WinnerResponse.from(response.getName()))
                .toList();
    }
}
