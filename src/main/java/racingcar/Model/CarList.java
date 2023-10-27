package racingcar.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarList {

	private final String ENTERED_SEPARATOR = ",";
	private final List<Car> carList = new ArrayList<>();

	public CarList(String enteredList) {

		String[] splitEnteredList = splitEnteredList(enteredList);

		for (String eachEnteredList : splitEnteredList) {
			this.carList.add(new Car(eachEnteredList.trim()));
		}

	}

	public void moveCarList() {

		for(Car eachCar : carList) {
			eachCar.move();
		}

	}


	private String[] splitEnteredList(String enteredList) {
		return enteredList.split(ENTERED_SEPARATOR);
	}

	public List<Car> findWinner() {

		Set<Car> removeList = makeRemoveList();
		List<Car> winningList = this.carList;

		for (Car removedCar : removeList) {
			winningList.remove(removedCar);
		}

		return winningList;

	}

	private Set<Car> makeRemoveList() {

		Set<Car> removeList = new HashSet<>();

		for (int i = 0; i < carList.size(); i++) {
			for (int j = 0; j < carList.size(); j++) {

				addRemoveList(removeList, i, j);

			}
		}

		return removeList;
	}

	private void addRemoveList(Set<Car> removeList, int referenceIndex, int comparableIndex) {
		final int COMPARE_EQUAL_SIGN = 0;

		if (carList.get(referenceIndex).compareDistance(carList.get(comparableIndex)) < COMPARE_EQUAL_SIGN) {
			removeList.add(carList.get(referenceIndex));
		}

	}

	public Car getEachCar(int index) {
		return carList.get(index);
	}

	public int size() {
		return carList.size();
	}

}
