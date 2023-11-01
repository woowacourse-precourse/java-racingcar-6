package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private ArrayList<Car> cars = new ArrayList<>();
	private int count;

	public void user() {

		String carNames = namesInput();
		processCarNamesInput(carNames);

		String count = countInput();
		processCountInput(count);
	}

	private String namesInput() {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		return Console.readLine();
	}

	private String countInput() {

		System.out.println("시도할 횟수는 몇회인가요?");

		return Console.readLine();

	}

	private void processCarNamesInput(String input) {

		String[] carNames = input.split(",");
		InputValid.names(carNames);

		for (int i = 0; i < carNames.length; i++) {
			String name = carNames[i];
			cars.add(new Car(name));
		}
	}

	private void processCountInput(String input) {

		count = Integer.parseInt(input);
		InputValid.count(count);
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public int getCount() {
		return count;
	}

}
