package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private final String ENTERED_SEPARATOR = ",";
	private List<Car> carList;

	public CarList(String enteredList) {

		String[] splitEnteredList = splitEnteredList(enteredList);

		carList = new ArrayList<>();

		for(String eachEnteredList : splitEnteredList) {
			this.carList.add(new Car(eachEnteredList.trim()));
		}

	}

	private String[] splitEnteredList(String enteredList) {
		return enteredList.split(ENTERED_SEPARATOR);
	}

	public Car getEachCar(int index) {
		return carList.get(index);
	}

	public int size() {
		return carList.size();
	}




}
