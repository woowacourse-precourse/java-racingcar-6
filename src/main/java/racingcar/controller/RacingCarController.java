package racingcar.controller;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.dto.CarRequestDto;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = new InputView();

    private RacingCarController() {
    }

    public static RacingCarController create() {
        return new RacingCarController();
    }

    public void startGame() {
        getCar();
    }

    private List<Car> getCar() {
        CarRequestDto carRequestDto = inputView.setCarNames();
        return carRequestDto.toCar();
    }
}
