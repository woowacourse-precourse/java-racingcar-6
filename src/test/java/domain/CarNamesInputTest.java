package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNamesInputTest {
	@Test
	public void 이름은_쉼표로_구분한다() {
		//given
		String names = "pobi,crong";
		// when
		CarNamesInput carNamesInput = new CarNamesInput();
		List<String> nameList = carNamesInput.splitByCommaToList(names);
		//then
		Assertions.assertThat(nameList.get(0)).isEqualTo("pobi");
		Assertions.assertThat(nameList.get(1)).isEqualTo("crong");
	}

	@Test
	void 이름은_5글자_이하가_아니라면_예외발생() {
		//given
		String name = "abcedf";
		CarNamesInput carNamesInput = new CarNamesInput();

		// when & then
		Assertions.assertThatThrownBy(() -> {
			carNamesInput.validateNameLength(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}

}
