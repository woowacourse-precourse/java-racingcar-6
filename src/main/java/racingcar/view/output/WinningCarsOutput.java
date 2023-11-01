package racingcar.view.output;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;

public class WinningCarsOutput {
    private static final String OUTPUT_FORMAT = "최종 우승자 : %s";
    private static final String CAR_NAMES_JOINING_DELIMETER = ", ";

    private final String output;

    private WinningCarsOutput(String output) {
        this.output = output;
    }

    public static WinningCarsOutput from(List<CarDto> carDtos) {
        return new WinningCarsOutput(OUTPUT_FORMAT.formatted(joinedNames(carDtos)));
    }

    private static String joinedNames(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(CarDto::name)
                .collect(Collectors.joining(CAR_NAMES_JOINING_DELIMETER));
    }

    public String output() {
        return output;
    }
}
