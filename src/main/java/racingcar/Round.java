package racingcar;

import java.util.List;

import racingcar.View.OutputView;

public class Round {
	public void runRound(List<Car> racingCars){
		for(Car car : racingCars){
			car.goForwardOrNot();
			OutputView.printRoundResult(car.getName(), car.getForwardCount());
		}
		System.out.println("");

	}
}
