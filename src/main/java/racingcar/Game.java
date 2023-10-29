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

	Game(Round round, List<Car> racingCars){
		this.round = round;
		this.racingCars = racingCars;
	}
	public void run(){
		setRacingCars();
		setRoundCount();
		for(int i = 0; i < roundCount; i++){
			if(i == 0){
				OutputView.printRoundStart();
			}
			round.runRound(racingCars);
		}
		List<String> winners = findWinner();
		OutputView.printWinner(winners);

	}

	private void setRacingCars(){
		String input = InputView.getCarNamesInput();
		validateCarNamesInput(input);
		this.racingCars = makeCarNamesInputToCarList(input);
	}
	private void setRoundCount(){
		String input = InputView.getRoundCountInput();
		validateRoundCountInput(input);
		this.roundCount = Integer.parseInt(input);
	}

	private List<String> findWinner(){
		List<String> winners = new ArrayList<>();
		int maxForwardCount = -1;

		for(Car car : racingCars){
			if(car.getForwardCount() > maxForwardCount){
				winners.clear();
				winners.add(car.getName());
				maxForwardCount = car.getForwardCount();
				continue;
			}
			if(car.getForwardCount() == maxForwardCount){
				winners.add(car.getName());
			}
		}
		return winners;
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

	private void validateRoundCountInput(String input){
		if(!input.matches("\\d+")){
			throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
		}
	}
}
