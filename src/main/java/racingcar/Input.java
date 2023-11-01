package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private ArrayList<Car> cars = new ArrayList<>();
	private int count;

	public void getUserInput() {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String input = Console.readLine();

		String[] carnames = input.split(",");

		InputValid.names(carnames);
		
		
		for (int i = 0; i < carnames.length; i++) {
			String name = carnames[i];
			cars.add(new Car(name));
		}

		System.out.println("시도할 횟수는 몇회인가요?");

		String cntstr = Console.readLine();

		count = Integer.parseInt(cntstr);

		InputValid.count(count);
		
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public int getCount() {
		return count;
	}

}
