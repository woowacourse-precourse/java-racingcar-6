package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class RacingCarWinnerFinder {

	private Integer winnerSteps = 0;
	private static final Integer indexSteps = 1;
	private List<String> winnerList = new ArrayList<>();

	public List<String> getRacingCarWinner(List<Car> carList, Integer index) {
		if (index == carList.size()) {
			return winnerList;
		}
		if (carList.get(index).steps == winnerSteps) {
			winnerList.add(carList.get(index).name);
		}
		if (carList.get(index).steps > winnerSteps) {
			winnerList.clear();
			winnerList.add(carList.get(index).name);
			winnerSteps = carList.get(index).steps;
		}
		return getRacingCarWinner(carList, index + indexSteps);
	}
}
