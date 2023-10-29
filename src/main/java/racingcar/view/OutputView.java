package racingcar.view;

import racingcar.component.ComponentWriter;
import racingcar.component.output.GameResultComponent;
import racingcar.component.output.RoundResultComponent;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.car.dto.output.WinnerNamesDto;

public final class OutputView {
    private final ComponentWriter componentWriter;

    public OutputView(final ComponentWriter componentWriter) {
        this.componentWriter = componentWriter;
    }

    public void printRoundResult(final CarsRacingDto dto) {
        componentWriter.write(new RoundResultComponent(dto));
    }

    public void printGameResult(final WinnerNamesDto dto) {
        componentWriter.write(new GameResultComponent(dto));
    }
}
