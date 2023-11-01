package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.CarList;
import racingcar.service.RacingCarService;
import racingcar.validation.RacingCarValidation;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarView view = new RacingCarView();
        RacingCarService service = new RacingCarService(new CarList(), new RacingCarValidation());
        RacingCarController racingCarController = new RacingCarController(service, view);

        racingCarController.initCar();
        int count = racingCarController.setCount();
        racingCarController.playGame(count);
        racingCarController.getWinner();

    }
}
