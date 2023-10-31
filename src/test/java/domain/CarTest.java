package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	public void 숫자가_4이상_9이하라면_전진한다(int randomNumber) {
		//given
		// when
		Car car = new Car();
		car.moveByNumber(randomNumber);
		//then
		Assertions.assertThat(car.getLocation()).isEqualTo(1);
	}
}
