package racingcar.engine.manager;

import static java.lang.String.format;
import static racingcar.engine.RacingCarSystem.RACING_RESULT_FORMAT;
import static racingcar.engine.RacingCarSystem.RACING_RESULT_PROGRESS_BAR;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.engine.domain.Car;

public class DisplayBoard {


    public String show(List<Car> cars) {
        return cars.stream()
                .map(this::convertExecutionResult)
                .collect(Collectors.joining("\n"));
    }

    private String convertExecutionResult(Car car) {
        String progressBar = drawProgressBar(car.getProgress());

        return format(RACING_RESULT_FORMAT.value(), car.getName(), progressBar);
    }

    private String drawProgressBar(int times) {
        String progressBar = RACING_RESULT_PROGRESS_BAR.value();

        return progressBar.repeat(times);
    }
}
