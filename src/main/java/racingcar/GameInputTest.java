package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

class GameInputTest {

	@Test
	@DisplayName("입력 문자열 파싱 테스트")
	void parseNamesTest() {
		String[] tmpArray = {"kim", "lee", "park", "choi", "jeong"};
		List<String> tmpList = Arrays.asList(tmpArray);
		assertThat(GameInput.parseNames("kim,lee,park,choi,jeong"))
			.isEqualTo(tmpList);
	}
	
	@Test
	@DisplayName("6자 이상 이름이 입력되었을 때 익셉션 발생 테스트")
	void parseExceptionTest() {
		assertThatThrownBy(() -> GameInput.parseNames("llllll"))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("정수가 아닌 값이 입력되었을 때 익셉션 발생 테스트")
	void trialExceptionTest() {
		assertThatThrownBy(() -> GameInput.getTrial())
        	.isInstanceOf(IllegalArgumentException.class);
	}

}
