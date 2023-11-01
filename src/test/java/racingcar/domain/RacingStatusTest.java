package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RacingStatusTest {
	private static final String CAR_NAME = "pobi,woni,jun";
	private static final String TRY_NUMBER = "5";

	@Test
	void create_Status_Test() {
		RacingStatus racingStatus = new RacingStatus(CAR_NAME, TRY_NUMBER);
		Map<String, Integer> carStatus = racingStatus.getCarStatus();
		assertEquals(3, carStatus.size());
		assertTrue(carStatus.containsKey("pobi"));
		assertTrue(carStatus.containsKey("woni"));
		assertTrue(carStatus.containsKey("jun"));
		assertEquals(0, carStatus.get("pobi").intValue());

		int tryNumber = racingStatus.getTryNumber();
		assertEquals(5, tryNumber);
	}

	@Test
	void findMaxValueFromCarStatus() {
		RacingStatus racingStatus = new RacingStatus(CAR_NAME, TRY_NUMBER);
		for (int i = 0; i < racingStatus.getTryNumber(); i++) {
			racingStatus.updateCarStatus();
		}
		List<String> functionResult = racingStatus.findMaxValueFromCarStatus();
		List<String> carStatusKeys = new ArrayList<>(racingStatus.getCarStatus().keySet());
		assertTrue(carStatusKeys.containsAll(functionResult));
	}

}