package racingcar;

import racingcar.domain.Cars;
import racingcar.service.CreateCarsService;
import racingcar.service.MoveCarsService;
import racingcar.service.PickWinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
	
	private final CreateCarsService createCarsService;
	private final MoveCarsService moveCarsService;
	private final PickWinnerService pickWinnerService;
	private final InputView inputView;
	private final OutputView outputView;
	
	public RacingCar() {
		this.createCarsService = new CreateCarsService();
		this.moveCarsService = new MoveCarsService();
		this.pickWinnerService = new PickWinnerService();
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void play() {
		Cars cars = createCars();
		
		progress(cars);
		
		pickWinner(cars);
	}
	
	private Cars createCars() {
		outputView.printInputCarName();
		
		String carNames = inputView.inputCarNames();
		Cars cars = createCarsService.createCars(carNames);
		
		return cars;
	}
	
	private void progress(Cars cars) {
		outputView.printInputTryNumber();
		
		int tryNumber = inputView.inputTryNumber();
		
		outputView.printExecutionResult();
		
		for(int i = 0; i < tryNumber; i++) {
			moveCarsService.moveCars(cars);
			outputView.printCurrentSituationOfCarLocation(cars.printCarsStatus());
		}
	}
	
	private void pickWinner(Cars cars) {
		String winner = pickWinnerService.printWinner(cars);
		
		outputView.printWinner(winner);
	}
}
