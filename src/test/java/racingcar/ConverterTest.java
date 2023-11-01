package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Converter class Test")
class ConverterTest {

	@Nested
	@DisplayName("convertToCarList() ")
	class ConverterNested1 {

		@Test
		@DisplayName("문자열을 받아 쉼표로 나눈 후 양 옆 공백을 제거한 다음 CarList를 반환한다.")
		void test01() {
			final var participants = "pobi , woni , jun";
			final var carList = Converter.stringToCarList(participants);
			assertThat(carList)
				.extracting("name")
				.containsExactlyInAnyOrder("pobi", "woni", "jun");
		}

		@Test
		@DisplayName("쉽표가 없다면 문자열을 나누지 않는다.")
		void test02() {
			final var participants = "gi wu";
			final var carList = Converter.stringToCarList(participants);
			assertThat(carList)
				.extracting("name")
				.containsExactlyInAnyOrder(participants);
		}
	}

	@Nested
	@DisplayName("convertToInteger")
	class ConverterNested2 {

		@ParameterizedTest
		@ValueSource(strings = {"1", "32", " 123 "})
		@DisplayName("양 옆 공백을 제거한 후 숫자로 변환한다.")
		void test01(final String number) {
			final var result = Converter.stringToInteger(number);
			final var trim = number.trim();
			assertThat(result).isEqualTo(Integer.parseInt(trim));
		}

		@Test
		@DisplayName("변환이 불가능 하다면 NumberFormatException을 던진 후 IllegalArgumentException으로 변환하여 던진다.")
		void test02() {
			final var participants = "cant convert";
			assertThatThrownBy(() -> Converter.stringToInteger(participants))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("숫자만 입력해주세요!")
				.getRootCause()
				.isInstanceOf(NumberFormatException.class);
		}
	}
}
