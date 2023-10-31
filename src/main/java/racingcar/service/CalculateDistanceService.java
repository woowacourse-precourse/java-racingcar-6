package racingcar.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.InputTryException;
import racingcar.view.InplayView;

public class CalculateDistanceService {
	private static final int MOVING_BOUNDARY = 4;
	private static final int RANDOM_START = 0;
	private static final int RANDOM_END = 9;
	private static final String MOVING_MAKR = "-";
	private InputTryException tryException = new InputTryException();
	private InplayView playView = new InplayView();

	public void move(Car car) {
		if (Randoms.pickNumberInRange(RANDOM_START, RANDOM_END) >= MOVING_BOUNDARY) {
			car.getDistance().append(MOVING_MAKR);
		}
		playView.printProgress(car.getName(), car.getDistance());
	}

	public void moveCars(List<Car> cars, int input) {
		for (int i = 0; i < input; i++) {
			move(cars.get(i));
		}
	}

	public void moveAll(Cars cars, int tryNum) {
		playView.printNotice();
		for (int i = 0; i < tryNum; i++) {
			moveCars(cars.getCars(), cars.getSize());
			System.out.println();
		}
	}

	public int getTry(String tryNumber) {
		tryException.checkException(tryNumber);
		System.out.println();
		return Integer.parseInt(tryNumber);
	}
}