package racingcar;

import racingcar.controller.RacingController;
import racingcar.respository.RacingRepository;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = getRacingController();
        racingController.run();
    }

    private static RacingController getRacingController() {
        RacingRepository racingRepository = new RacingRepository();
        RacingService racingService = new RacingService(racingRepository);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController racingController = new RacingController(racingService, inputView, outputView);
        return racingController;
    }
}
