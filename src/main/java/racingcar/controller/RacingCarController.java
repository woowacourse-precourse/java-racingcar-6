package racingcar.controller;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarListMaker;
import racingcar.car.CarMovementController;
import racingcar.output.OutputController;
import racingcar.tryingcounts.TryingCounts;

public class RacingCarController {

	OutputController outputController = new OutputController();

	public void start() {
		outputController.printCarNameInputMessage();
		CarListMaker carListMaker = new CarListMaker();
		List<Car> carList = carListMaker.makeCarList();
		outputController.printTryingCountsInputMessage();
		TryingCounts tryingCounts = new TryingCounts();
		Integer tryingCountsNumber = tryingCounts.getTryingCounts();
		System.out.println(tryingCountsNumber);
		CarMovementController carMovementController = new CarMovementController();
		String racingCarResult = carMovementController.moveCars(carList, tryingCountsNumber);
		outputController.printResult(racingCarResult);
	}
}
