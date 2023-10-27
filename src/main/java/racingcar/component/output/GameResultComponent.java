package racingcar.component.output;

import static strings.Strings.COMMAS;
import static strings.Strings.LINE_BREAK;
import static strings.Strings.WHITE_SPACE;

import racingcar.component.Component;
import racingcar.domain.car.dto.output.CarsFinishedDto;

public final class GameResultComponent implements Component {

    private static final String TEXT = "최종 우승자 : %s";
    private final CarsFinishedDto dto;

    public GameResultComponent(final CarsFinishedDto dto) {
        this.dto = dto;
    }

    @Override
    public String render() {
        return String.format(LINE_BREAK + LINE_BREAK + TEXT,
                String.join(
                        COMMAS + WHITE_SPACE,
                        dto.winnerNames()
                )
        );
    }
}
