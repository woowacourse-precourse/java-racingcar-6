package racingcar.component.output;

import static strings.Strings.COMMAS;
import static strings.Strings.LINE_BREAK;
import static strings.Strings.WHITE_SPACE;

import java.util.List;
import racingcar.component.Component;
import racingcar.domain.car.dto.output.WinnerDto;
import racingcar.domain.car.dto.output.WinnersDto;

public final class GameResultComponent implements Component {

    private static final String TEXT = "최종 우승자 : %s";
    private final WinnersDto dto;

    public GameResultComponent(final WinnersDto winnersDto) {
        this.dto = winnersDto;
    }

    @Override
    public String render() {
        final List<String> winnerNames = dto.winners().stream().map(WinnerDto::carName).toList();
        return String.format(LINE_BREAK + LINE_BREAK + TEXT,
                String.join(
                        COMMAS + WHITE_SPACE,
                        winnerNames
                )
        );
    }
}
