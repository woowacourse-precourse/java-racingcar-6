package racingcar.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarListService {
	private final String ENTERED_LIST_SEPARATOR = ",";
	private final List<Car> CAR_LIST = new ArrayList<>();

	public List<Car> makeCarList(String enteredList) {

		String[] splitEnteredList = splitEnteredList(enteredList);

		for (String eachCarName : splitEnteredList) {

			Car car = new Car(eachCarName);
			car.validateName();
			CAR_LIST.add(car);

		}

		validateSize();

		return CAR_LIST;

	}

	private void validateSize() {
		final int MIN_LIST_LENGTH = 2;

		if(CAR_LIST.size() < MIN_LIST_LENGTH) {
			throw new IllegalArgumentException("2대 이상의 자동차가 존재해야 합니다.");
		}
	}

	private String[] splitEnteredList(String enteredList) {
		return enteredList.split(ENTERED_LIST_SEPARATOR);
	}

	public void moveCarList() {

		for (Car eachCar : CAR_LIST) {
			eachCar.move();
		}

	}

	public String findWinner() {

		List<Car> winnerList = makeWinnerList();

		return toStringWinner(winnerList);
	}

	private List<Car> makeWinnerList() {

		Set<Car> removeList = makeRemoveList();
		List<Car> winnerList = CAR_LIST;

		for (Car removedCar : removeList) {
			winnerList.remove(removedCar);
		}

		return winnerList;

	}

	private Set<Car> makeRemoveList() {

		Set<Car> removeList = new HashSet<>();

		for (int i = 0; i < CAR_LIST.size(); i++) {
			for (int j = 0; j < CAR_LIST.size(); j++) {

				addRemoveList(removeList, i, j);

			}
		}

		return removeList;
	}

	private void addRemoveList(Set<Car> removeList, int referenceIndex, int comparableIndex) {

		if (isRemovedCar(referenceIndex, comparableIndex)) {
			removeList.add(CAR_LIST.get(referenceIndex));
		}

	}

	private boolean isRemovedCar(int referenceIndex, int comparableIndex) {

		final int COMPARE_EQUAL_SIGN = 0;

		return CAR_LIST.get(referenceIndex).compareDistance(CAR_LIST.get(comparableIndex)) < COMPARE_EQUAL_SIGN;
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

}
