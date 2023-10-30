package racingcar.race;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import racingcar.car.Car;

public class Race {
	private int laps;
	private ArrayList<Car> cars;

	public Race() {
		cars = new ArrayList<>();
	}

	public void init() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = readLine();
		StringTokenizer st = new StringTokenizer(input, ",");
		while (st.hasMoreTokens()) {
			Car car = new Car(st.nextToken().toString());
			if (car.getName().length() == 0 || car.getName().length() > 5) {
				throw new IllegalArgumentException("자동차 이름은 한 글자 이상, 다섯 글자 이하로 입력되어야 합니다.");
			}
			cars.add(car);
		}
		System.out.println("시도할 회수는 몇회인가요?");
		String tryNumStr = readLine();
		int tryNum = Integer.parseInt(tryNumStr);
		if (tryNum <= 0) {
			throw new IllegalArgumentException("시도 횟수는 0 보다 커야합니다.");
		}
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
