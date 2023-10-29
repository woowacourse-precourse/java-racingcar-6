package racingcar;

import java.util.ArrayList;

public class PrintGenerator {

	public PrintGenerator() {

	}

	public void printNameQuestion() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void printCountQuestion() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public void printMoveResult(InformationOfCar car) {
		System.out.println(car.getCarName() + " : " + car.getDistance());
	}
}
