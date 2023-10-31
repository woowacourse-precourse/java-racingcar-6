//RacingCars.java
package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.View.OutputView;

public class RacingCars {
	final private List<Car> racingCars;
	RacingCars(List<Car> racingCars){
		this.racingCars = racingCars;
	}

	public void runRound(){
		for(Car car : racingCars){
			car.move();
			OutputView.printRoundResult(car.getName(), car.getMoveCount());
		}
		OutputView.printEmptyLine();
	}

	public List<Car> findWinner(){
		List<Car> winners = new ArrayList<>();
		for(Car car : racingCars){
			if(winners.isEmpty()){
				winners.add(car);
				continue;
			}

			boolean isFaster = car.checkIsFaster(winners.get(0));
			boolean isSame = car.checkIsSame(winners.get(0));

			if(isFaster){
				winners.clear();
				winners.add(car);
			}
			if(isSame){
				winners.add(car);
			}
		}
		return winners;
	}

	public List<String> getCarNames(List<Car> cars){
		List<String> carNames = new ArrayList<>();
		for(Car car : cars){
			carNames.add(car.getName());
		}
		return carNames;
	}
}
