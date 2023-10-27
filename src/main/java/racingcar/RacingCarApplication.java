package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.CarNamesInputView;
import racingcar.view.InputMessageView;
import racingcar.view.RacingTurnsInput;

public class RacingCarApplication {

    RacingController racingController;

    public RacingCarApplication() {
        racingController = new RacingController();
    }

    public void run() {
        inputCarNames();
        int racingTurns = Integer.parseInt(inputRacingTurns());


    }

    private void inputCarNames() {
        racingController.createRacingCars(CarNamesInputView.input());
    }

    private String inputRacingTurns() {
        return RacingTurnsInput.input();
    }


}
