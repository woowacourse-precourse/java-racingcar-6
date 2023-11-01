package racingcar.race;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import racingcar.car.Car;
import racingcar.util.Validator;

public class Race {
	private int laps;
	private ArrayList<Car> cars;

	public Race() {
		cars = new ArrayList<>();
	}

	public void init() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = readLine();
		Validator.inputEndsWithComma(input);
		Validator.inputStartsWithComma(input);
		StringTokenizer st = new StringTokenizer(input, ",");
		while (st.hasMoreTokens()) {
			Car car = new Car(st.nextToken().toString());
			cars.add(car);
		}
		Validator.distinctNameOnly(cars);
		System.out.println("시도할 회수는 몇회인가요?");
		String tryNumStr = readLine();
		Validator.parsableToNumber(tryNumStr);
		int tryNum = Integer.parseInt(tryNumStr);
		Validator.numberIsOverZero(tryNum);
		this.laps = tryNum;
	}

	public void start() {
		for (int i = 0; i < laps; i++) {
			for (int j = 0; j < cars.size(); j++) {
				Car car = cars.get(j);
				if (car.decideMoveOrNot()) {
					car.move();
				}
			}
			printRace();
		}
	}

	public void printRace() {
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			car.printMoveResult();
		}
		System.out.println();
	}

	public void announceWinner() {
		ArrayList<Car> cars = getWinner();

		System.out.print("최종 우승자 : ");
		Car winner = cars.get(0);
		System.out.print(winner.getName());
		for (int i = 1; i < cars.size(); i++) {
			Car car = getWinner().get(i);
			if (car.getMoveCount() == winner.getMoveCount()) {
				System.out.print(", ");
				System.out.print(car.getName());
			}
		}
	}

	public ArrayList<Car> getWinner() {
		Collections.sort(this.cars, new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				return (Integer.compare(o2.getMoveCount(), o1.getMoveCount()));
			}
		});
		return this.cars;
	}
}
