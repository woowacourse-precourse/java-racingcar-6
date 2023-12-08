package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Objects;

public class Input {
	public String readCarName(){
		String carName = readLine();
		isValidValues(carName);
		return carName;
	}

	private void isValidValues(String carName) {
		String[] carNameArr = carName.split(",");
		for (String car : carNameArr){
			if (Objects.equals(car, "\\d+")) throw new IllegalArgumentException();
			if (car.length() >= 5) throw new IllegalArgumentException();
		}
	}

	public int readCount(){
		String count = readLine();
		return Integer.parseInt(count);
	}
}
