package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.RacingCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();
	private List<Car> carNames;
	private RacingCount racingCount;
	
	public void start() {
		// TODO Auto-generated method stub
		outputView.printInputCarName();
		carNames = inputView.inputCarNames();
		outputView.printInputRaceCount();
		racingCount = inputView.inputRacingCount();
	}
	
	
}
