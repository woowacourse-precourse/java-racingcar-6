package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

	public void start() {
		// TODO Auto-generated method stub
		OutputView.printInputCarName();
		String carNames = InputView.inputCarNames();
	}

}
