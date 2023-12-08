package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarService {
	public List<Car> makeCarList(String name){
		List<Car> cars = new ArrayList<>();
		String[] nameArr = name.split(",");
		for (String s : nameArr) {
			cars.add(new Car(s));
		}
		return cars;
	}

	public boolean isCanMove(){
		int randomNumber = Randoms.pickNumberInRange(0,9);
		return randomNumber >= 4;
	}

	public List<Car> setCarMoved(List<Car> cars, int count){
		for (int i = 0; i < count; i++){
			cars.forEach(car -> {
				car.addMove(isCanMove());
			});
			Output.printMoveResult(cars);
		}
		return cars;
	}

	public List<String> pickWinnerInCarList(List<Car> cars){
		List<String> winner = new ArrayList<>();
		int highest = setHighestScore(cars);
		for (Car car : cars){
			if (car.howManyMoved() == highest){
				winner.add(car.name);
			}
		}
		return winner;
	}

	public int setHighestScore(List<Car> cars){
		int highest = 0;
		for (Car car : cars){
			if (car.howManyMoved() >= highest){
				highest = car.howManyMoved();
			}
		}
		return highest;
	}
}
