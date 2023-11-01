package Carset;

import java.util.ArrayList;
import java.util.List;

public class PrintResult {
	private List<Car> cars; //Car을 기준으로 List 생성

	public PrintResult(List<String> carNames) { //입력 받은 이름을 Car객체에 대입하여 자동차에 전진 조건 추가
		this.cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void start() {
		System.out.println("실행 결과");
	}

	public void printStatus() { //자동차 전진과 그에 따른 출력 메서드

		int number = CarFuctSet.inputNumber();

		start();

		for (int i = 0; i < number; i++) {
			moveCars();
			printCarsStatus();
		}

		List<String> winners = determineWinners(); //승자를 뽑는 리스트
		printWinners(winners);

	}

	private void moveCars() { //자동차에 전진조건 메서드
		for (Car car : cars) {
			car.moveCondition();
		}
	}

	private void printCarsStatus() { // 출력 메서드
		for (Car car : cars) {
			printCarStatus(car);
		}
		System.out.println();
	}

	private void printCarStatus(Car car) { //승자를 표현 하는 메서드
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getDistance(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private List<String> determineWinners() { // 가장 많이 전진한 사용자를 뽑아 승자를 표현하는 메서드
		int maxDistance = 0;
		List<String> winners = new ArrayList<>();

		for (Car car : cars) {
			int distance = car.getDistance();

			if (distance > maxDistance) {
				maxDistance = distance;
				winners.clear();
				winners.add(car.getName());
			} else if (distance == maxDistance) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

	private void printWinners(List<String> winners) {
		System.out.println("\n최종 우승자 : " + String.join(",", winners));
	}

}
