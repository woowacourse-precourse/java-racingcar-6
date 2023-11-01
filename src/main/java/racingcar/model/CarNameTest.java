package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CarNameTest {
	@Test
	void test1() {
		String input = "abcdef";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(input));
	}
	void test2() {
		String input = " ";
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(input));
	}
}
