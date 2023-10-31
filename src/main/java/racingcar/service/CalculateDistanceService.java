package racingcar.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.InputTryException;
import racingcar.view.InplayView;

public class CalculateDistanceService {
	static final int MOVE_BOUNDARY = 4;
	private InputTryException tryException = new InputTryException();
	private InplayView playView = new InplayView();

	public void move(Car car) {
		if (Randoms.pickNumberInRange(0,9) >= MOVE_BOUNDARY) {
			car.getDistance().append("-");
		}
		playView.printProgress(car.getName(), car.getDistance());
	}

	public void repeatMove(List<Car> cars, int input) {
		for (int i=0; i<input; i++) {
			move(cars.get(i));
		}
	}

	public void moveCars(Cars cars, int tryNum) {
		playView.printNotice();
		for (int i=0; i<tryNum; i++) {
			repeatMove(cars.getCars(), cars.getSize());
			System.out.println();
		}
	}

	public int getTry(String tryNumber) {
		tryException.checkException(tryNumber);
		System.out.println();
		return Integer.parseInt(tryNumber);
	}
}