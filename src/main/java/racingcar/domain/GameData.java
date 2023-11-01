package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameData {

	private List<String> carList = new ArrayList<>();
	private List<Integer> numberList = new ArrayList<>();
	private List<Integer> positionList = new ArrayList<>();
	private List<String> winnersList = new ArrayList<>();

	public List<String> getCarList() {
		return carList;
	}

	public void setCarList(String[] carNames) {
		for (String carName : carNames) {
			carList.add(carName);
		}
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

	public void resetNumberList() {
		numberList.clear();
	}

	public List<Integer> getPositionList() {
		return positionList;
	}

	public void setInitPositionList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			positionList.add(i, 0);
		}
	}

	public List<String> getWinnersList() {
		return winnersList;
	}

}
