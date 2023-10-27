package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
	static final String ONE_STEP = "-";
	
	public static void printStartGame() {
		System.out.println("실행 결과");
	}
	
	public static void printRound(Car car) {
		//printCarName(car.carName);
		//printCarLocation(car.carLocation);
		System.out.println("");
	}
	
	private static void printCarName(String carName) {
//		System.out.print(car.carName + " : ");
	}
	
	private static void printCarLocation(int carLocation) {
		while (carLocation!=0) {
			System.out.print(ONE_STEP);
			carLocation--;
		}
	}
	
	public static void printResult(List<String> winner, int winnerNumber) {
		Message.resultMessage(winner, winnerNumber);
	}
}