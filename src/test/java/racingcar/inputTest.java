package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class inputTest {

	@Test
	void split_입력된_값을_구분() {
		String input = "pobi,jun,woni";
		String[] result = input.split(",");
		
		assertThat(result).contains("jun","woni","pobi");
		assertThat(result).containsExactly("pobi","jun","woni");
	}
	
	void charAt_제한된_문자열의_길이보다_크면_예외_발생() {
		String input = "pororo";
		
		assertThatThrownBy(() -> input.length())
				.isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("String indeex out of range: 5");
	}
}
