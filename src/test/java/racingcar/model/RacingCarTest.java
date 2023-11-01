package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class RacingCarTest {
	private RacingCar aaa = new RacingCar("aaa");
	private RacingCar bbb = new RacingCar("bbb");
	private RacingCar ccc = new RacingCar("ccc");
	private RacingCar ddd = new RacingCar("ddd");

	@Test
	@DisplayName("시작 위치가 0인지 확인")
	void initPositionTest() {
		Assertions.assertEquals(0, aaa.getPosition());
		Assertions.assertEquals(0, bbb.getPosition());
		Assertions.assertEquals(0, ccc.getPosition());
		Assertions.assertEquals(0, ddd.getPosition());
	}
}
