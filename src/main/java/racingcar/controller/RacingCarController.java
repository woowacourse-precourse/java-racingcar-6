package racingcar.controller;

import java.util.List;
import racingcar.dto.CarNameDto;
import racingcar.model.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {
    InputView inputView = new InputView();
    RacingCarService service = new RacingCarService();

    public List<CarNameDto> splitCarName() {
        return service.carNameExtraction(inputView.getUserInput());
    }
}
