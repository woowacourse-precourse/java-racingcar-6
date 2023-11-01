package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarMover {

	private static final Integer RandomStartNumber = 0;
	private static final Integer RandomEndNumber = 9;
	private static final Integer MovingFowardStartNumber = 4;
	private static final Integer CarSteps = 1;
	private static final Integer RecursiveSteps = 1;
	private static final Integer EndOfRecursive = 0;
	private static final Integer StartIndex = 0;
	private static final Integer IndexIncreaseNumber = 1;
	CarMovementWriter carMovementWriter = new CarMovementWriter();

	public void moveCars(List<Car> carList, Integer tryingCountsNumber,
		CarMovementResultLogStorage carMovementResultLogStorage) {
		updateCarMovements(carList, StartIndex);
		carMovementWriter.writeMovementOfCars(carList, StartIndex, carMovementResultLogStorage);
		tryingCountsNumber = tryingCountsNumber - RecursiveSteps;
		if (tryingCountsNumber == EndOfRecursive) {
			return;
		}
		moveCars(carList, tryingCountsNumber, carMovementResultLogStorage);
	}

	private void updateCarMovements(List<Car> carList, Integer index) {
		if (index == carList.size()) {
			return;
		}
		Integer askForMoving = Randoms.pickNumberInRange(RandomStartNumber, RandomEndNumber);
		if (askForMoving >= MovingFowardStartNumber) {
			carList.get(index).steps += CarSteps;
		}
		updateCarMovements(carList, index + IndexIncreaseNumber);
	}


}
