package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Game {
	Round round;
	List<Car> racingCars;
	int roundCount;
	public void run(){
		setRacingCars();
		setRoundCount();
		for(int i = 0; i < roundCount; i++){
			round.runRound(racingCars);
		}
		Car winner = findWinner();
		OutputView.printWinner(winner);

	}

	private void setRacingCars(){
		String input = InputView.getCarNamesInput();
		validateCarNamesInput(input);
		this.racingCars = makeCarNamesInputToCarList(input);
	}

	private void setRoundCount(){}

	private Car findWinner(){
		Car winner = new Car("name");
		return winner;
	}

	private void validateCarNamesInput(String input){
		if(!input.contains(",")){
			throw new IllegalArgumentException("이름은 쉼표(,)로 구분해야 합니다.");
		}
		String[] carsArray = input.split(",");
		for(String car : carsArray){
			if(car.length() > 5){
				throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
			}
		}
	}

	private List<Car> makeCarNamesInputToCarList(String input){
		List<Car> racingCars = new ArrayList<>();
		String[] carNamesArray = input.split(",");
		for(String carName : carNamesArray){
			Car car = makeCarInstance(carName);
			racingCars.add(car);
		}
		return racingCars;
	}

	private Car makeCarInstance(String name){
		return new Car(name);
	}
}
