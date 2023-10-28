package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class OutputViewTest extends IOTest {
	static OutputView outputView = new OutputView();

	static Car makeCar(String name, Long forwardCount) {
		Car car = new Car(name);
		while (forwardCount-- > 0) {
			car.moveForward();
		}
		return car;
	}

	@Test
	void 출력_변환_테스트() {
		List<Car> cars = new ArrayList<>();
		cars.add(makeCar("a", 6L));
		cars.add(makeCar("b", 4L));
		cars.add(makeCar("c", 6L));
		assertThat(outputView.getRoundResult(cars)).isEqualTo("a : ------\nb : ----\nc : ------\n\n");
	}

	@Test
	void 출력_누적_테스트() {
		List<Car> round1 = new ArrayList<>();
		round1.add(makeCar("a", 6L));
		round1.add(makeCar("b", 4L));
		round1.add(makeCar("c", 6L));
		outputView.stackRoundResult(outputView.getRoundResult(round1));

		List<Car> round2 = new ArrayList<>();
		round2.add(makeCar("a", 7L));
		round2.add(makeCar("b", 5L));
		round2.add(makeCar("c", 7L));
		outputView.stackRoundResult(outputView.getRoundResult(round2));

		captureSystemOut(() -> outputView.printGameResult());

		String expectedOutput =
			"실행 결과\n"
				+ "a : ------\n"
				+ "b : ----\n"
				+ "c : ------\n"
				+ "\n"
				+ "a : -------\n"
				+ "b : -----\n"
				+ "c : -------";

		assertThat(getCapturedOutput()).isEqualTo(expectedOutput);
	}

}