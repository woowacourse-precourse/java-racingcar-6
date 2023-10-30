package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 전진_정지() {
		assertRandomNumberInRangeTest(
				() -> {
					run("pobi,woni", "1");
					assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
				},
				MOVING_FORWARD, STOP
		);
	}

	@Test
	void 이름에_대한_예외_처리() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("pobi,javaji", "1"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}

	@Test
	@DisplayName("자동차 이름 입력 테스트1 - 1개 입력 시 정상 동작")
	void carNameTest1() {
		Race race = new Race();
		Car car = new Car("poby");

		List<Car> carList = new ArrayList<>();
		carList.add(car);
		race.setCarList(carList);

		assertThat(carList).isEqualTo(race.getCarList());
	}

	@Test
	@DisplayName("자동차 이름 입력 테스트2 - 3개 입력 시 정상 동작")
	void carNameTest2() {
		Race race = new Race();
		Car car1 = new Car("poby");
		Car car2 = new Car("woni");
		Car car3 = new Car("jinee");

		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		race.setCarList(carList);

		assertThat(carList).isEqualTo(race.getCarList());
	}

	@Test
	@DisplayName("자동차 이름 입력 테스트3 - 입력하지 않았을 경우 예외 처리")
	void carNameTest3() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("", "1"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("자동차 이름 입력 테스트4 - 6글자 이상일 경우 예외 처리")
	void carNameTest4() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("jinwoo", "1"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("시도 횟수 입력 테스트1 - 5를 입력하였을 경우 정상 동작")
	void turnCountTest1() {
		int testValue = 5;
		Race race = new Race();
		race.setTurnCount(testValue);

		assertThat(race.getTurnCount()).isEqualTo(testValue);
	}

	@Test
	@DisplayName("시도 횟수 입력 테스트2 - 입력하지 않았을 경우 예외 처리")
	void turnCountTest2() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("pobi", null))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("시도 횟수 입력 테스트3 - 정수가 아닌 입력값일 경우 예외 처리")
	void turnCountTest3() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("pobi", "one"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}
}
