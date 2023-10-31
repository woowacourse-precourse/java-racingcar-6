package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CalculateDistanceService;
import racingcar.service.DecideWinnerService;
import racingcar.service.GenerateCarsService;
import racingcar.view.InplayView;
import racingcar.view.StartView;
import racingcar.view.TryNumberInputView;

public class GameController {
	private GenerateCarsService generateCarsService = new GenerateCarsService();
	private CalculateDistanceService calculateDistanceService = new CalculateDistanceService();
	private DecideWinnerService decideWinnerService = new DecideWinnerService();
	private StartView startView = new StartView();
	private TryNumberInputView tryView = new TryNumberInputView();
	private InplayView playView = new InplayView();
	private Cars cars = new Cars();

	public void start() {
		generateCarsService.generateCars(getNames(), cars);
		moveCars();
		playView.printWinner(getWinner());
	}

	public String getNames() {
		return startView.inputName();
	}

	public int getTry() {
		return calculateDistanceService.getTry(tryView.inputTry());
	}

	public void moveCars() {
		calculateDistanceService.moveCars(cars, getTry());
	}

	public String getWinner() {
		return decideWinnerService.getResult(cars.getCars());
	}
}