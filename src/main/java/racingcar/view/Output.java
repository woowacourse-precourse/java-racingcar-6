package racingcar.view;

import java.util.LinkedList;
import java.util.List;

import racingcar.model.Car;

public class Output {
	public final String RESULT_MESSAGE = "실행 결과";
	public final String WINNER_MESSAGE = "최종 우승자";
	
	public void resultMessage() {
		System.out.println(RESULT_MESSAGE);
	}
	
	public void roundResult(List<Car> cars) {
		for(Car car : cars) {
			System.out.printf("%s : %s\n", car.getName(), car.getForwardCount());
		}
		System.out.println();
	}
	
	public void winner(List<Car> winnerCars) {
		
		List<String> carName = new LinkedList<String>();
		for(Car car : winnerCars) {
			carName.add(car.getName());
		}
		
		System.out.print(WINNER_MESSAGE + " : ");
		System.out.print(String.join(", ", carName));
	}
}
