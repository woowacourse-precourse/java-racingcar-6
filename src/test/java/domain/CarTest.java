package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void moveByNumber_메서드로_숫자가_4이상_9이하라면_전진한다(int randomNumber) {
		//given
		String name = "pobi";
		Car car = new Car(name);

		// when
		car.moveByNumber(randomNumber);

		//then
		Assertions.assertThat(car.getLocation()).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void moveByNumber_메서드로_숫자가_0이상_3이하라면_멈춘다(int randomNumber) {
		//given
		String name = "pobi";
		Car car = new Car(name);

		// when
		car.moveByNumber(randomNumber);

		//then
		Assertions.assertThat(car.getLocation()).isEqualTo(0);
	}

	@Test
	public void createHyphenByLocation_메서드로_자동차가_움직인_거리만큼_하이픈_생성() {
		//given
		String name = "pobi";
		Car car = new Car(name);
		car.moveByNumber(4);

		// when
		String hyphenByLocation = car.createHyphenByLocation();

		//then
		Assertions.assertThat(hyphenByLocation).isEqualTo("-");
	}

	@Test
	void createHyphenByLocation_메서드로_자동차가_움직인_거리_없다면_빈값() {
		//given
		String name = "pobi";
		Car car = new Car(name);
		car.moveByNumber(3);

		// when
		String hyphenByLocation = car.createHyphenByLocation();

		//then
		Assertions.assertThat(hyphenByLocation).isEqualTo("");
	}
}
