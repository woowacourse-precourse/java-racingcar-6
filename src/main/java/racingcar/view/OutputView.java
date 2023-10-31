package racingcar.view;

import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.car.dto.output.WinnersDto;
import racingcar.view.component.ComponentWriter;
import racingcar.view.component.output.GameResultComponent;
import racingcar.view.component.output.RoundResultComponent;

public final class OutputView {
    private final ComponentWriter componentWriter;

    public OutputView(final ComponentWriter componentWriter) {
        this.componentWriter = componentWriter;
    }

    public void printRoundResult(final CarsRacingDto carsDto) {
        componentWriter.write(new RoundResultComponent(carsDto));
    }

    public void printGameResult(final WinnersDto winnersDto) {
        componentWriter.write(new GameResultComponent(winnersDto));
    }
}
