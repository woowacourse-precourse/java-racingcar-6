package racingcar.car;

import java.util.List;

public class CarMovementWriter {

	private static final String ChangeLine = "\n";
	private static final String Colon = " : ";
	private static final String StepSign = "-";
	private static final String EmptyInitialString = "";
	private static final Integer StartCarSteps = 0;
	private static final Integer IndexSteps = 1;

	public void writeMovementOfCars(List<Car> carList, Integer index,
		CarMovementResultLogStorage carMovementResultLogStorage) {
		if (index == carList.size()) {
			return;
		}
		carMovementResultLogStorage.addLog(
			carList.get(index).name + Colon + checkMovedStepsOfCar(carList.get(index))
				+ ChangeLine);

		carMovementResultLogStorage.addLog(ChangeLine);
		writeMovementOfCars(carList, index + IndexSteps, carMovementResultLogStorage);
	}

	private String checkMovedStepsOfCar(Car car) {
		String stepsOfCar = EmptyInitialString;
		for (int i = StartCarSteps; i < car.steps; i++) {
			stepsOfCar = stepsOfCar + StepSign;
		}
		return stepsOfCar;
	}
}
