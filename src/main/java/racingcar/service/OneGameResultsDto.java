package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.service.domain.Car;

public class OneGameResultsDto {
    private final List<ResultDto> oneGameResults;

    public OneGameResultsDto(final List<Car> cars) {
        this.oneGameResults = convertToOneGameResults(cars);
    }

    private List<ResultDto> convertToOneGameResults(final List<Car> cars) {
        List<ResultDto> oneGameResults = new ArrayList<>();
        for (Car car : cars) {
            oneGameResults.add(new ResultDto(car.getName(), car.getTotalMoveCount()));
        }
        return oneGameResults;
    }
}
