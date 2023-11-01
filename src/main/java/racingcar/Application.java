package racingcar;

import racingcar.domain.controller.RacingCarController;
import racingcar.domain.service.CreateListService;
import racingcar.domain.service.OutputService;

public class Application {
    public static void main(String[] args) {
        OutputService outputService = new OutputService();
        CreateListService createListService = new CreateListService();
        RacingCarController racingCarController = new RacingCarController(createListService, outputService);
        racingCarController.run();
    }
}
