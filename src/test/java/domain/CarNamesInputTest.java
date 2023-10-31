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
}
