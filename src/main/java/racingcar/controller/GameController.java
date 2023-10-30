package racingcar.controller;

import racingcar.domain.Car;
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
		generateCars(generateCarsService.getNames(getNames()), cars);
		moveCars();
		playView.printWinner(getWinner());
	}

	public String getNames() {
		String names = startView.inputName();
		return names;
	}

	public void generateCars(String[] carArray, Cars cars) {
		for (int i=0; i<carArray.length; i++) {
			Car car = new Car();
			car.setName(carArray[i]);
			cars.setCars(car);
		}
	}

	public int getTry() {
		int tryNumber = calculateDistanceService.getTry(tryView.inputTry());
		System.out.println();
		return tryNumber;
	}

	public void moveCars() {
		calculateDistanceService.moveCars(cars, getTry());
	}

	public String getWinner() {
		String winner = decideWinnerService.getResult(cars.getCars());
		return winner;
	}
	// startView에서 이름 받아오기	(O)
	// 유효성 검사				(O)
	// Car객체 생성해서 이름 넣기	(O)
	// Car객체들 Cars에 넣기		(O)
	// tryView에서 시도횟수 받아오기(O)
	// 유효성 검사				(O)
	// 루프 인덱스로 사용			(O)
	// inplayView.printNotice
	// 반복문으로 Cars 반복, service.repeat, printResult
	//
}