package racingcar.car;

import java.util.List;

public class CarMovementController {

	CarMover carMover = new CarMover();
	CarMovementWinnerWriter carMovementWinnerWriter = new CarMovementWinnerWriter();
	CarMovementResultLogStorage carMovementResultLogStorage = new CarMovementResultLogStorage();
	private static final String FirstLineOfTheLog = "\n실행결과\n";

	public String moveCars(List<Car> carList, Integer tryingCountsNumber) {
		carMovementResultLogStorage.addLog(FirstLineOfTheLog);
		carMover.moveCars(carList, tryingCountsNumber, carMovementResultLogStorage);
		carMovementWinnerWriter.writeCarMovementWinner(carList, carMovementResultLogStorage);
		return carMovementResultLogStorage.getResultStringOfCarMovements();
	}


}
