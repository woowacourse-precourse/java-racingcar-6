package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.CarNamesInputView;
import racingcar.view.InputMessageView;

public class RacingCarApplication {

    RacingController racingController;

    public RacingCarApplication() {
        racingController = new RacingController();
    }


    public void run() {
        inputCarNames();

    }





    private void inputCarNames() {
        racingController.createRacingCars(CarNamesInputView.input());
    }
}
