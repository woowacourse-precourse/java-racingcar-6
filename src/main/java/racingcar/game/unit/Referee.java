package racingcar.game.unit;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Referee {

	public static Referee newReferee() {
		return new Referee();
	}

	private Referee() {
	}

	public Course selectCourse() {
		String response = askAttempt();
		int attempt = Integer.parseInt(response);
		return Course.of(attempt);
	}

	private String askAttempt() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Console.readLine();
	}

	public void broadcast(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + " : " + getCarPosition(car));
		}
		System.out.println();
	}

	private String getCarPosition(Car car) {
		StringBuilder position = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			position.append("-");
		}
		return position.toString();
	}

	public void announceWinner(List<Car> cars) {
		int maxPosition = getMaxPosition(cars);
		List<String> winners = getWinners(cars, maxPosition);
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}

	private int getMaxPosition(List<Car> cars) {
		return cars
				.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElse(0);
	}

	private List<String> getWinners(List<Car> cars, int maxPosition) {
		return cars
				.stream()
				.filter(car -> Objects.equals(car.getPosition(), maxPosition))
				.map(Car::getName)
				.collect(Collectors.toList());
	}

	public void announceRacingStart() {
		System.out.println();
		System.out.println("실행 결과");
	}
}
