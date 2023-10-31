package racingcar.view;

import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class Output {
	static final String ONE_STEP = "-";
	
	public static void printRunResultGuide() {
		Message.lineSpaceMessage();
		Message.runResultGuideMessage();
	}
	
	public static void printRound(List<CarDTO> carList, RoundDTO round) {
		for (int i=0; i<carList.size(); i++) {
			CarDTO car = carList.get(i);
			printCarName(car.getCarName());
			printCarLocation(car.getCarLocation());
			Message.lineSpaceMessage();
		}
		Message.lineSpaceMessage();
	}
	
	private static void printCarName(String carName) {
		Message.carNameMessage(carName);
		Message.colonMessage();
	}
	
	private static void printCarLocation(int carLocation) {
		while (carLocation!=0) {
			System.out.print(ONE_STEP);
			carLocation--;
		}
	}
	
	public static void printResult(List<CarDTO> winner) {
		Message.resultMessage();
		printWinner(winner);
	}
	
	private static void printWinner(List<CarDTO> winner) {
		String carName;
		int winnerNumber = winner.size();
		for (int i=0; i<winnerNumber - 1; i++) {
			carName = winner.get(i).getCarName();
			Message.carNameMessage(carName);
			Message.commaMessage();
		}
		carName = winner.get(winnerNumber-1).getCarName();
		Message.carNameMessage(carName);
	}
}