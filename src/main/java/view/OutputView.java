package view;

import java.util.List;

import racingcar.Car;
import racingcar.CarList;
import racingcar.Winners;

public class OutputView {
	private static final String OUTPUT_RESULT = "실행 결과";
	private static final String OUTPUT_FINAL_WINNERS = "최종 우승자 : ";
	private static final String OUTPUT_ONE_POSITION = "-";
	private static final String OUTPUT_FINAL_WINNERS_DELIMITER = ", ";

	public void printResult(CarList carList) {
		System.out.println(OUTPUT_RESULT);
		printCarList(carList);

	}

	private void printCarList(CarList carList) {
		for (Car car : carList.getCarList()) {
			car.stopOrMove();
			printNameAndPosition(car);
		}
		System.out.println();
	}

	public void printNameAndPosition(Car car) {
		System.out.println(car.getName() + " : " + printPosition(car.getPosition()));
	}

	public String printPosition(int position) {
		String temp = "";
		for (int i = 0; i < position; i++) {
			temp += OUTPUT_ONE_POSITION;
		}
		return temp;
	}

	public void printWinners(Winners winners) {
		System.out.println(OUTPUT_FINAL_WINNERS + join(winners.getWinners()));
	}

	public String join(List<String> input) {
		return String.join(OUTPUT_FINAL_WINNERS_DELIMITER, input);
	}

}