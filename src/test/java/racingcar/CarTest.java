package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.model.Car;

public class CarTest {

	private final int MOVE_SIGN = 4;
	private Car car;

	@BeforeEach
	void createCar() {
		this.car = new Car("Curry");
	}

	@DisplayName("자동차가 기입한 이름에 맞게, 이동 거리가 초기화 되어 생성되는지 확인한다.")
	@Test
	void createCarTest() {

		//given
		String name = "James ";

		//when
		Car testCar = new Car(name);
		String actualName = testCar.toString();
		int actualDistance = testCar.getDistance();

		//then
		final String EXPECTED_NAME = "James";
		final int EXPECTED_DISTANCE = 0;

		assertAll(
			() -> assertEquals(EXPECTED_NAME, actualName, "이름이 다릅니다."),
			() -> assertEquals(EXPECTED_DISTANCE, actualDistance, "이동 거리가 0이 아닙니다.")
		);

	}

	@DisplayName("자동차의 이름이 5자가 넘어가면 예외가 발생한다.")
	@Test
	void inputOverSizeName() {
		final String EXPECTED_MESSAGE = "5자 이하의 이름있는 자동차만 넣을 수 있습니다.";

		assertThatThrownBy(() -> new Car("123456"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(EXPECTED_MESSAGE);
	}

	@DisplayName("자동차의 이름이 없으면 예외가 발생한다.")
	@Test
	void inputBlankName() {
		final String EXPECTED_MESSAGE = "5자 이하의 이름있는 자동차만 넣을 수 있습니다.";

		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(EXPECTED_MESSAGE);
	}

	@DisplayName("자동차가 정지해 있는지 확인한다.")
	@ParameterizedTest
	//given
	@ValueSource(ints = {0, 1, 2, 3})
	void stopTest(int element) {

		//when
		car.moveOrStop(element);
		int actualDistance = car.getDistance();

		//then
		final int EXPECTED_DISTANCE = 0;
		assertThat(actualDistance).isEqualTo(EXPECTED_DISTANCE);

	}

	@DisplayName("자동차가 1만큼 이동하는지 있는지 확인한다.")
	@ParameterizedTest
	//given
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void moveTest(int element) {

		//when
		car.moveOrStop(element);
		int actualDistance = car.getDistance();

		//then
		final int EXPECTED_DISTANCE = 1;
		assertThat(actualDistance).isEqualTo(EXPECTED_DISTANCE);

	}

	@DisplayName("자동차가 n번 이동하는지 확인한다.")
	@ParameterizedTest
	//given
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void moveSeveralTimeTest(int n) {

		//when
		for (int i = 0; i < n; i++) {
			car.moveOrStop(MOVE_SIGN);
		}
		int actualDistance = car.getDistance();

		//then
		assertEquals(n, actualDistance);

	}

	@DisplayName("두 자동차를 비교해서 뒤처져 있는지, 아닌지 확인한다.")
	@Test
	void laggingCarTest() {

		//given
		final int DISTANCE_A = 5;
		final int DISTANCE_B = 3;

		Car carA = new Car("A");
		Car carB = new Car("B");

		//when
		for (int i = 0; i < DISTANCE_A; i++) {
			carA.moveOrStop(MOVE_SIGN);
		}

		for (int i = 0; i < DISTANCE_B; i++) {
			carB.moveOrStop(MOVE_SIGN);
		}

		boolean actualAToB = carA.isLaggingCar(carB);
		boolean actualBTOA = carB.isLaggingCar(carA);

		//then
		assertFalse(actualAToB);
		assertTrue(actualBTOA);

	}

	@DisplayName("자동차의 이동 거리를 그래프로 확인한다.")
	@ParameterizedTest
	//given
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void getStatusTest(int distance) {

		//given
		String graphUnit = "->";

		//when
		for (int i = 0; i < distance; i++) {
			car.moveOrStop(MOVE_SIGN);
		}

		String actualGraph = car.getStatus(graphUnit);

		//then
		final String EXPECTED_GRAPH = car + " : " + graphUnit.repeat(distance);
		assertEquals(EXPECTED_GRAPH, actualGraph);
	}

}
