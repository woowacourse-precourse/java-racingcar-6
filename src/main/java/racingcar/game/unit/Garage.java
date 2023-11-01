package racingcar.game.unit;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {

	public static Garage newGarage() {
		return new Garage();
	}

	private Garage() {
	}

	public List<Car> publishCars() {
		String response = askCarNames();
		List<String> carNameList = getCarNameList(response);
		return getCars(carNameList);
	}

	private String askCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine();
	}

	private List<String> getCarNameList(String response) {
		return new ArrayList<>(List.of(
				response.split(",")));
	}

	private List<Car> getCars(List<String> carNameList) {
		return carNameList
				.stream()
				.map(Car::of)
				.collect(Collectors.toList());
	}
}
