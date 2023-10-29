package racingcar.component.output;

import static strings.Strings.COMMAS;
import static strings.Strings.LINE_BREAK;
import static strings.Strings.WHITE_SPACE;

import racingcar.component.Component;
import racingcar.domain.car.dto.output.WinnerNamesDto;

public final class GameResultComponent implements Component {

    private static final String TEXT = "최종 우승자 : %s";
    private final WinnerNamesDto dto;

    public GameResultComponent(final WinnerNamesDto dto) {
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
