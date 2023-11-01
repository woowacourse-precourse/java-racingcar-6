package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Converter {

	public static List<Car> stringToCarList(final String names) {
		final var nameList = names
			.split(",");
		final var carList = new ArrayList<Car>();
		for (var name : nameList) {
			final var car = new Car(name.trim());
			carList.add(car);
		}
		return carList;
	}

	public static int stringToInteger(final String number) {
		try {
			final String trim = number.trim();
			return Integer.parseInt(trim);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력해주세요!", e);
		}
	}
}
