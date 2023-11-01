package racingcar.car;

import java.util.List;

public class CarMovementWriter {

	private static final String ChangeLine = "\n";
	private static final String Colon = " : ";
	private static final String StepSign = "-";
	private static final String EmptyInitialString = "";
	private static final Integer StartCarSteps = 0;

	public void writeMovementOfCars(List<Car> carList,
		CarMovementResultLogStorage carMovementResultLogStorage) {
		for (Car car : carList) {
			carMovementResultLogStorage.addLog(
				car.name + Colon + checkMovedStepsOfCar(car) + ChangeLine);
		}
		carMovementResultLogStorage.addLog(ChangeLine);
	}

	private String checkMovedStepsOfCar(Car car) {
		String stepsOfCar = EmptyInitialString;
		for (int i = StartCarSteps; i < car.steps; i++) {
			stepsOfCar = stepsOfCar + StepSign;
		}
		return stepsOfCar;
	}
}
