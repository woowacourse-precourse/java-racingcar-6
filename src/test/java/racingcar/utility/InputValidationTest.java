package racingcar.utility;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;
import static racingcar.utility.InputValidation.*;

import org.junit.jupiter.api.Test;

class InputValidationTest {

	void nameException(String name, String errorMessage) {
		assertThatThrownBy(() -> validateName(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(errorMessage);
	}

	void numberException(String input, String errorMessage) {
		assertThatThrownBy(() -> validateNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(errorMessage);
	}

	@Test
	void 이름의_길이가_긴_경우() {
		String name = "abcdef";
		nameException(name, LENGTH_ERROR.getMessage());
	}

	@Test
	void 이름의_길이가_0일_경우() {
		String name = "";
		nameException(name, LENGTH_ERROR.getMessage());
	}

	@Test
	void 이름이_공백으로만_구성된_경우() {
		String name = " 	";
		nameException(name, SPACE_ERROR.getMessage());
	}

	@Test
	void 이름에_공백이_포함된_경우() {
		String name = " a	";
		assertThat(name).isEqualTo(validateName(name));
	}

	@Test
	void 이름_문자열_정상입력() {
		String name = "abcd";
		assertThat(name).isEqualTo(validateName(name));
	}

	@Test
	void 라운드_입력이_숫자가_아닐_경우() {
		String input = "a";
		numberException(input, NUMBER_ERROR.getMessage());
	}

	@Test
	void 라운드_입력이_음수일_경우() {
		String input = "-3";
		numberException(input, NEGATIVE_ERROR.getMessage());
	}

	@Test
	void 라운드_입력이_0일_경우() {
		String input = "0";
		assertThat(Long.parseLong(input)).isEqualTo(validateNumber(input));
	}

	@Test
	void 라운드_숫자_정상입력() {
		String input = "5";
		assertThat(Long.parseLong(input)).isEqualTo(validateNumber(input));
	}
}
