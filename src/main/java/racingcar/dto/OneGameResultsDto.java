package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
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

    public int size() {
        return oneGameResults.size();
    }

    public List<ResultDto> getResults() {
        return Collections.unmodifiableList(oneGameResults);
    }

    public List<Integer> getTotalMoveCounts() {
        List<Integer> totalMoveCounts = new ArrayList<>();
        oneGameResults.forEach(resultDto -> totalMoveCounts.add(resultDto.getTotalMoveCount()));
        return Collections.unmodifiableList(totalMoveCounts);
    }
}
