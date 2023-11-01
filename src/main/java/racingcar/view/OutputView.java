package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputView {
	
	private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String RACE_COUNT_INPUT = "시도할 회수는 몇회인가요?";
	private static final String RESULT = "시도할 회수는 몇회인가요?";
	private static final String WINNER = "최종 우승자 : ";
	
	public static void printInputCarName() {
		System.out.println(CAR_NAME_INPUT);
		
	}

	public static void printInputRaceCount() {
		System.out.println(RACE_COUNT_INPUT);
	}
	
	public static void printMove(List<Car> cars) {
		for (Car car : cars) {
            System.out.println(car);
        }
	}
	
	public static void printResult() {
		System.out.println();
		System.out.println(RESULT);
	}
	
	public static void printWinners(List<String> winners) {
		System.out.println(WINNER + String.join(", ", winners));
	}

}
