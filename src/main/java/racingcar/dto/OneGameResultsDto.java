package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.domain.Car;

public class OneGameResultsDto {
    private final List<ResultDto> oneGameResults;

    public OneGameResultsDto(final List<Car> endCars) {
        this.oneGameResults = convertToOneGameResults(endCars);
    }

    private List<ResultDto> convertToOneGameResults(final List<Car> endCars) {
        return endCars.stream()
                .map(car -> new ResultDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
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
