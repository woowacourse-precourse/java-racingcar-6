package racingcar.view.component.output;

import static strings.util.Strings.COMMAS;
import static strings.util.Strings.LINE_BREAK;
import static strings.util.Strings.WHITE_SPACE;

import java.util.List;
import racingcar.domain.car.dto.output.WinnerDto;
import racingcar.domain.car.dto.output.WinnersDto;
import racingcar.view.component.Component;

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
