package racingcar.model;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	static ArrayList<Car> carList;
	static int cycle;
	public void gameStart() {
		getInputCarName();

		getInputCycle();

		printOneRace();

		printResult();
	}

	static void getInputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = Console.readLine();
		if(input.isBlank()) {
			throw new IllegalArgumentException("이름을 입력하지 않았습니다.");
		}
		String[] nameInput = input.replaceAll(" ", "").split(",");
		carList = new ArrayList<>();
		for (String name : nameInput) {
			if (name.length() > 5) {
				throw new IllegalArgumentException("이름은 5자 이내로 작성해주세요.");
			}
			carList.add(new Car(name, 0));
		}
	}

	static void getInputCycle() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		cycle = Integer.parseInt(Console.readLine());
	}

	static void printOneRace() {
		System.out.println("\n실행 결과");
		for (int i = 0; i < cycle; i++) {
			randomDrive(carList);
			printDistance();
		}
	}

	static void randomDrive(ArrayList<Car> carList) {
		for (Car car : carList) {
			int randomNum = Randoms.pickNumberInRange(0, 9);
			car.carDrive(randomNum);
		}
	}

	static void printDistance() {
		for (Car car : carList) {
			System.out.print(car.getName() + " : ");
			for (int j = 0; j < car.getCount(); j++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void printResult() {
		int maxDistance = getMaxDistance();
		printWinner(maxDistance);
	}

	static int getMaxDistance() {
		int maxDistance = 0;
		for (Car car : carList) {
			if (car.getCount() > maxDistance) {
				maxDistance = car.getCount();
			}
		}
		return maxDistance;
	}

	static void printWinner(int maxDistance) {
		ArrayList<String> winnerList = new ArrayList<>();
		for (Car car : carList) {
			if (car.getCount() == maxDistance) {
				winnerList.add(car.getName());
			}
		}
		System.out.println("최종 우승자 : " + String.join(", ", winnerList));
	}
}
