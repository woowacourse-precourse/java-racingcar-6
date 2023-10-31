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
		String[] nameArray = {"kim", "lee", "park"};
		Pair[] tmpArray = new Pair[3];
		
		for (int i = 0; i < 3; i++) {
			tmpArray[i] = new Pair();
			tmpArray[i].setName(nameArray[i]);
			tmpArray[i].setLocation(0);
		}
		
		List<Pair> tmpList = Arrays.asList(tmpArray);
		List<Pair> testList = GameInput.parseNames("kim,lee,park");
		
		assertThat(testList.get(0).getName()).isEqualTo(tmpList.get(0).getName());
		assertThat(testList.get(0).getLocation()).isEqualTo(tmpList.get(0).getLocation());
		assertThat(testList.get(1).getName()).isEqualTo(tmpList.get(1).getName());
		assertThat(testList.get(1).getLocation()).isEqualTo(tmpList.get(1).getLocation());
		assertThat(testList.get(2).getName()).isEqualTo(tmpList.get(2).getName());
		assertThat(testList.get(2).getLocation()).isEqualTo(tmpList.get(2).getLocation());
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
