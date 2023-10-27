package racingcar.component.output;

import static strings.Strings.DASH;
import static strings.Strings.LINE_BREAK;

import java.util.stream.Collectors;
import racingcar.component.Component;
import racingcar.domain.car.dto.output.CarRacingDto;
import racingcar.domain.car.dto.output.CarsRacingDto;
import strings.Strings;

public final class RoundResultComponent implements Component {

    private static boolean isFirstRender = true;

    private final CarsRacingDto dto;

    public RoundResultComponent(final CarsRacingDto dto) {
        this.dto = dto;
    }

    @Override
    public String render() {
        if (isFirstRender) {
            isFirstRender = false;
            return new ExecutionResultComponent()
                    .render()
                    + renderCarsData();
        }
        return LINE_BREAK + LINE_BREAK + renderCarsData();
    }

    private String renderCarsData() {
        return dto.carRacing()
                .stream()
                .map(this::renderCarData)
                .collect(Collectors.joining(LINE_BREAK));
    }

    private String renderCarData(final CarRacingDto dto) {
        return String.format("%s : %s",
                dto.carName(),
                Strings.repeat(DASH, dto.coordinate())
        );
    }


}
