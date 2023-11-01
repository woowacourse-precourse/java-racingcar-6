package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	public void 이름_중복_테스트() {
		assertThatThrownBy(() ->  new Cars("pobi,pobi,jun"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("중복된 이름입니다.");
	}
}
