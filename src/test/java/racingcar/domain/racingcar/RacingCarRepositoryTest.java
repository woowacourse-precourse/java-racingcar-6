package racingcar.domain.racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarRepositoryTest extends NsTest {
	private RacingCar racingCar;

	private Map<String, RacingCar> racingCarMap = new LinkedHashMap<>();

	@BeforeEach
	void setup() {
		racingCar = new RacingCar("pobi");
	}

	@Test
	void RacingCar_생성_시_이름_검증() {
		String carName = "";
		assertAll(
				() -> assertThrows(IllegalArgumentException.class,
						() -> new RacingCar(carName)),
				() -> assertEquals("pobi", racingCar.getCarName())
		);
	}

	@DisplayName("racingCar의_이름을_key로_지정하여_save")
	@ParameterizedTest(name = "{index}. {displayName} - carName: {0}")
	@ValueSource(strings = {"woni", "pobi"})
	void racingCar의_이름을_key로_지정하여_save(String carName) {
		racingCarMap.put(carName, new RacingCar(carName));
		assertEquals(carName,  racingCarMap.get(carName).getCarName());
	}

	@Override
	protected void runMain() {

	}
}