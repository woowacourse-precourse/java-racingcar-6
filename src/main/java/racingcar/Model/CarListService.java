package racingcar.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarListService {

	private final String ENTERED_LIST_SEPARATOR = ",";
	private final List<Car> CAR_LIST = new ArrayList<>();

	public List<Car> make(String enteredList) {

		String[] splitEnteredList = splitEnteredList(enteredList);

		for (String eachCarName : splitEnteredList) {

			Car car = new Car(eachCarName);
			car.validateName();
			CAR_LIST.add(car);

		}

		validateSize();

		return CAR_LIST;

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

	private void validateSize() {

		final int MIN_LIST_LENGTH = 2;

		if (CAR_LIST.size() < MIN_LIST_LENGTH) {
			throw new IllegalArgumentException("2대 이상의 자동차가 존재해야 합니다.");
		}

	}

	public void move() {

		for (Car eachCar : CAR_LIST) {
			eachCar.moveOrStop();
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
			addRemoveList(removeList, i);
		}

		return removeList;
	}

	private void addRemoveList(Set<Car> removeList, int referenceIndex) {

		Car referenceCar = CAR_LIST.get(referenceIndex);

		for (Car comparableCar : CAR_LIST) {

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

}
