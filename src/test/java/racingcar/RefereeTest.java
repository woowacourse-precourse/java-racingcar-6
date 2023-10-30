package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

	@DisplayName("무작위 값이 4 이상이면 true를 반환한다.")
	@Test
	void testTryOutcomeTrue() {
		List<String> names = Arrays.asList("pobi", "woni", "jun");
		Referee referee = new Referee(names);
		List<Integer> randomNumbers = Arrays.asList(3, 4, 5);
		HashMap<String, Boolean> tryOutcome = referee.checkTryOutcome(randomNumbers);
		assertThat(tryOutcome.get("woni")).isEqualTo(true);
	}

	@DisplayName("무작위 값이 4 미만이면 false를 반환한다.")
	@Test
	void testTryOutcomeFalse() {
		List<String> names = Arrays.asList("pobi", "woni", "jun");
		Referee referee = new Referee(names);
		List<Integer> randomNumbers = Arrays.asList(3, 4, 5);
		HashMap<String, Boolean> tryOutcome = referee.checkTryOutcome(randomNumbers);
		assertThat(tryOutcome.get("pobi")).isEqualTo(false);
	}
}