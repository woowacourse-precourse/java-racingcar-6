package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(); // InputView를 인스턴스화
        RacingService racingService = new RacingService(); // RacingService를 인스턴스화
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController(inputView, racingService);
        racingController.run();
    }
}
