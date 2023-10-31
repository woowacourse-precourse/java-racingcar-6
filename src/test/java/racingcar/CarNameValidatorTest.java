package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {
	private CarNameValidator carNameValidator;
	private static final String message = "자동차 이름은 1자 이상 5자 이하여야 합니다.";

	@BeforeEach
	void setUp() {
		carNameValidator = new CarNameValidator();
	}

	@Test
	@DisplayName("자동차 이름은 0자 -> 예외발생 테스트")
	void carNameValidatorTest1() {
		String[] arr = {""};
		assertThatThrownBy(() -> carNameValidator.validateCarName(arr))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(message);
	}

	@Test
	@DisplayName("자동차 이름은 6자 -> 예외발생 테스트")
	void carNameValidatorTest2() {
		String[] arr = {"abcdef"};
		assertThatThrownBy(() -> carNameValidator.validateCarName(arr))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(message);
	}

	@Test
	@DisplayName("자동차 이름은 7자 -> 예외발생 테스트")
	void carNameValidatorTest3() {
		String[] arr = {"abcdefg"};
		assertThatThrownBy(() -> carNameValidator.validateCarName(arr))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(message);
	}

	@Test
	@DisplayName("자동차 이름은 1~5자만 가능하다.")
	void carNameValidatorTest4() {
		String[] arr1 = {"a"};
		String[] arr2 = {"ab"};
		String[] arr3 = {"abc"};
		String[] arr4 = {"abcd"};
		String[] arr5 = {"abcde"};

		List<String[]> arrList = new ArrayList<>();
		arrList.add(arr1);
		arrList.add(arr2);
		arrList.add(arr3);
		arrList.add(arr4);
		arrList.add(arr5);

		for (int i = 0; i < arrList.size(); i++) {
			carNameValidator.validateCarName(arrList.get(i));
		}
	}
}