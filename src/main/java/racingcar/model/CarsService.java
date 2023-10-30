package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsService {

	private final String ENTERED_LIST_SEPARATOR = ",";
	private final List<Car> CARS = new ArrayList<>();

	public List<Car> make(String enteredList) {

		String[] splitEnteredList = splitEnteredList(enteredList);

		for (String eachCarName : splitEnteredList) {

			Car car = new Car(eachCarName);
			CARS.add(car);

		}

		return CARS;

	}

	private String[] splitEnteredList(String enteredList) {

		validateSeparator(enteredList);

		return enteredList.split(ENTERED_LIST_SEPARATOR);
	}

	private void validateSeparator(String enteredList) {

		if (!enteredList.contains(ENTERED_LIST_SEPARATOR)) {
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

		List<Car> winnerList = makeWinnerList();

		return toStringWinner(winnerList);
	}

	private List<Car> makeWinnerList() {

		Set<Car> removeList = makeLaggingCarList();
		List<Car> winnerList = CARS;

		for (Car removedCar : removeList) {
			winnerList.remove(removedCar);
		}

		return winnerList;
	}

	private Set<Car> makeLaggingCarList() {

		Set<Car> removeList = new HashSet<>();

		for (int i = 0; i < CARS.size(); i++) {
			addLaggingCarList(removeList, i);
		}

		return removeList;
	}

	private void addLaggingCarList(Set<Car> removeList, int referenceIndex) {

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

	public void clear() {
		CARS.clear();
	}

}
