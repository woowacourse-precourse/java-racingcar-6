package racingcar.view;

import racingcar.component.ComponentWriter;
import racingcar.component.output.GameResultComponent;
import racingcar.component.output.RoundResultComponent;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.car.dto.output.WinnersDto;

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
