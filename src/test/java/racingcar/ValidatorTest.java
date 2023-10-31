package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
	private final Validator validator = new Validator();

	@Nested
	@DisplayName("validateName 메서드는")
	class DescribeValidateName {
		private String name;

		@Nested
		@DisplayName("name이 5글자 이하인 경우")
		class ContextWith5down {
			@BeforeEach
			void beforeEach() {
				name = "test";
			}

			@Test
			@DisplayName("예외를 발생시키지 않는다.")
			void itThrowNoException() {
				assertThatCode(() -> validator.validateName(name))
						.doesNotThrowAnyException();
			}
		}

		@Nested
		@DisplayName("name이 5글자 초과인 경우")
		class ContextWith5up {
			@BeforeEach
			void beforeEach() {
				name = "earlgrey02";
			}

			@Test
			@DisplayName("IllegalArgumentException을 발생시킨다.")
			void itThrowIllegalArgumentException() {
				assertThatThrownBy(() -> validator.validateName(name))
						.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	@Nested
	@DisplayName("validateCount 메서드는")
	class DescribeValidateCount {
		private String count;

		@Nested
		@DisplayName("count가 숫자 형식인 경우")
		class ContextWithInt {
			@BeforeEach
			void beforeEach() {
				count = "5";
			}

			@Test
			@DisplayName("예외를 발생시키지 않는다.")
			void itThrowNoException() {
				assertThatCode(() -> validator.validateCount(count))
						.doesNotThrowAnyException();
			}
		}

		@Nested
		@DisplayName("count가 숫자 형식이 아닌 경우")
		class ContextWithNoInt {
			@BeforeEach
			void beforeEach() {
				count = "earlgrey02";
			}

			@Test
			@DisplayName("IllegalArgumentException을 발생시킨다.")
			void itThrowIllegalArgumentException() {
				assertThatCode(() -> validator.validateCount(count))
						.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}