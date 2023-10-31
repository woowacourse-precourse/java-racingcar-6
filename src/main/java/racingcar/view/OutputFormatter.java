package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.ResultCar;
import racingcar.dto.ResultCars;

public class OutputFormatter {

    private static final String SPACE = " ";
    private static final String COLON = ":";
    private static final String COMMAS = ",";
    private static final String VISUALIZED_STATUS = "-";

    public List<String> printCarDistanceStatus(final Cars cars) {
        final List<String> carStatus = new ArrayList<>();

        for (Car car : cars.getCars()) {
            String viewDistance = appendStatus(car.getDistance());
            carStatus.add(car.getName() + SPACE + COLON + SPACE + viewDistance);
        }

        return carStatus;
    }

    private String appendStatus(final int distance) {
        return VISUALIZED_STATUS.repeat(Math.max(0, distance));
    }

    public String printWinner(final ResultCars resultCars) {
        return resultCars.getResultCars().stream()
                .map(ResultCar::getName)
                .collect(Collectors.joining(COMMAS + SPACE));
    }
}
