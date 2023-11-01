package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

	@Test
	void testCarNamWhenCarNameIsBlank() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("  ,   ,  ,"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void testTryNumberWhenTryNumberString() {
		assertThatThrownBy(() -> {
			Application.validateAndParseTry("문자");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	/**
	 * 차가 생성 될때에 차 이름과 개수가 제대로 Car클라스 안에 들어가는지 확인
	 */
	@Test
	void testCreateCarsFromNamesFunction() {
		String[] carNames = {"우테코", "붙고싶다", "붙여주세요"};
		List<Car> cars = Application.createCarsFromNames(carNames);

//		assertEquals(carNames.length, cars.size());

		for (int i = 0; i < carNames.length; i++) {
			assertEquals(carNames[i], cars.get(i).name);
		}
	}

	/**
	 * printWinner메소드의 값이 요구사항에 값과 똑같이 출력 되는지 테스트
	 */
	@Test
	void testPrintWinnerFunction() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		List<Car> cars = new ArrayList<>();

		Car rakCar = new Car("락윤");
		Car wooCar = new Car("우와");
		Car courceCar = new Car("코스");

		rakCar.setScore(5);
		wooCar.setScore(5);
		courceCar.setScore(3);

		cars.add(rakCar);
		cars.add(wooCar);
		cars.add(courceCar);
		Application.printWinner(cars, 5);
		String actualOutput = outputStream.toString().trim();

		assertEquals("최종 우승자 : 락윤, 우와", actualOutput);
	}

	@Test
	void testSetHighestScoreFunction(){
		List<Car> cars = new ArrayList<>();

		Car rakCar = new Car("락윤");
		Car wooCar = new Car("우와");
		Car courceCar = new Car("코스");

		rakCar.setScore(5);
		wooCar.setScore(5);
		courceCar.setScore(3);

		cars.add(rakCar);
		cars.add(wooCar);
		cars.add(courceCar);

		int highestScore = Application.setHighestScore(cars);

		assertEquals(highestScore, 5);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}


}
