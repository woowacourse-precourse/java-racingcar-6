package racingcar.domain;

import java.util.List;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.dto.CarDto;
import racingcar.view.output.GameOutputView;

public class RacingCarGame {
    private final Cars cars;
    private PlayCount playCount;

    RacingCarGame(Cars cars, PlayCount playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    public static RacingCarGame of(List<String> carNames, int playCount) {
        return new RacingCarGame(Cars.from(carNames), PlayCount.from(playCount));
    }

    public void play(MovingStrategy movingStrategy) {
        GameOutputView.printPlayResultTitle();
        do {
            playCount = playCount.play();
            cars.move(movingStrategy);
            GameOutputView.printPlayResults(cars.dtos());
        } while (!playCount.finished());
    }

    public List<CarDto> winningCarDtos() {
        return cars.maxPositionCarDtos();
    }
}
