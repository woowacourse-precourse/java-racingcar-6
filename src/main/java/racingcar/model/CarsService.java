package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsService {

	private final String INPUT_SEPARATOR = ",";
	private final List<Car> CARS = new ArrayList<>();

	public List<Car> make(String carNames) {

		String[] splitCarNames = splitInput(carNames);

		for (String eachCarName : splitCarNames) {

			Car car = new Car(eachCarName);
			CARS.add(car);

		}

		return CARS;

	}

	private String[] splitInput(String carNames) {

		validateSeparator(carNames);

		return carNames.split(INPUT_SEPARATOR);
	}

	private void validateSeparator(String enteredList) {

		if (!enteredList.contains(INPUT_SEPARATOR)) {
			throw new IllegalArgumentException("자동차 이름을 구분자(,)를 이용해 나눠주세요.");
		}

	}

	public void moveOrStop(List<Integer> randomNumbers) {

		for (int i = 0; i < CARS.size(); i++) {

			Car eachCar = CARS.get(i);
			int eachRandomNumber = randomNumbers.get(i);

			eachCar.moveOrStop(eachRandomNumber);
		}

	}

	public String findWinner() {

		List<Car> winnerList = makeWinners();

		return toStringWinner(winnerList);
	}

	private List<Car> makeWinners() {

		Set<Car> removeList = makeLaggingCars();
		List<Car> winnerList = CARS;

		for (Car removedCar : removeList) {
			winnerList.remove(removedCar);
		}

		return winnerList;
	}

	private Set<Car> makeLaggingCars() {

		Set<Car> removeList = new HashSet<>();

		for (int i = 0; i < CARS.size(); i++) {
			addLaggingCar(removeList, i);
		}

		return removeList;
	}

	private void addLaggingCar(Set<Car> removeList, int referenceIndex) {

		Car referenceCar = CARS.get(referenceIndex);

		for (Car comparableCar : CARS) {

			if (referenceCar.isLaggingCar(comparableCar)) {
				removeList.add(referenceCar);
				break;
			}

		}

	}

	private String toStringWinner(List<Car> winnerList) {

		final int INIT_INDEX = 0;

		StringBuilder winner = new StringBuilder();

		winner.append(winnerList.get(INIT_INDEX));

		for (int i = 1; i < winnerList.size(); i++) {
			winner.append(", ").append(winnerList.get(i));
		}

		return winner.toString();
	}

	public List<String> makeGraphs(String graphUnit) {
		List<String> graphs = new ArrayList<>();

		for (Car car : CARS) {
			String eachGraph = car.getStatus(graphUnit);
			graphs.add(eachGraph);
		}

		return graphs;
	}

	public void clear() {
		CARS.clear();
	}

	public int size() {
		return CARS.size();
	}

}
