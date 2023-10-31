package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.domain.Car;

public class OneGameResultsDto {
    private final List<ResultDto> oneGameResults;

    public OneGameResultsDto(final List<Car> cars) {
        this.oneGameResults = convertToOneGameResults(cars);
    }

    private List<ResultDto> convertToOneGameResults(final List<Car> cars) {
        return cars.stream()
                .map(car -> new ResultDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public int size() {
        return oneGameResults.size();
    }

    public List<ResultDto> getResults() {
        return Collections.unmodifiableList(oneGameResults);
    }

    public List<Integer> getTotalPositions() {
        List<Integer> totalPositions = new ArrayList<>();
        oneGameResults.forEach(resultDto -> totalPositions.add(resultDto.getPosition()));
        return Collections.unmodifiableList(totalPositions);
    }
}
