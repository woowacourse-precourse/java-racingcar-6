package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();

	public void start() {
		// TODO Auto-generated method stub
		outputView.printInputCarName();
		List<Car> carNames = inputView.inputCarNames();
	}

}
