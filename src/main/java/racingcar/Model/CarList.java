package racingcar.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarList {
	private final String ENTERED_LIST_SEPARATOR = ",";
	private final List<Car> carList = new ArrayList<>();

	public CarList(String enteredList) {

		String[] splitEnteredList = splitEnteredList(enteredList);

		for (String eachCarName : splitEnteredList) {

			validateCarName(eachCarName);
			carList.add(new Car(eachCarName.trim()));

		}

	}

	private void validateCarName(String eachCarName) {

		final int LENGTH_LIMIT = 5;

		if (eachCarName.length() > LENGTH_LIMIT) {
			throw new IllegalArgumentException("5글자 이하의 이름만 입력해주세요.");
		}

	}

	public void moveCarList() {

		for (Car eachCar : carList) {
			eachCar.move();
		}

	}

	private String[] splitEnteredList(String enteredList) {
		return enteredList.split(ENTERED_LIST_SEPARATOR);
	}

	public String findWinner() {

		List<Car> winnerList = makeWinnerList();

		return toStringWinner(winnerList);
	}

	private List<Car> makeWinnerList() {

		Set<Car> removeList = makeRemoveList();
		List<Car> winnerList = carList;

		for (Car removedCar : removeList) {
			winnerList.remove(removedCar);
		}

		return winnerList;

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

		if (isRemovedCar(referenceIndex, comparableIndex)) {
			removeList.add(carList.get(referenceIndex));
		}

	}

	private boolean isRemovedCar(int referenceIndex, int comparableIndex) {

		final int COMPARE_EQUAL_SIGN = 0;

		return carList.get(referenceIndex).compareDistance(carList.get(comparableIndex)) < COMPARE_EQUAL_SIGN;
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

	public Car getEachCar(int index) {
		return carList.get(index);
	}

	public int size() {
		return carList.size();
	}

}
