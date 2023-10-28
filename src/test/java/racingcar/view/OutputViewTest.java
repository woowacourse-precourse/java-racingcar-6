package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.domain.Cars;
import racingcar.service.CreateCarsService;

public class OutputViewTest extends NsTest {

	@DisplayName("실행결과 메세지를 확인한다.")
	@Test
	void checkPrintExecutionResult() {
		OutputView outputView = new OutputView();
		CreateCarsService createService = new CreateCarsService();

		Cars cars = createService.createCars("car1,car2,car3");
		
		outputView.printExecutionResult(cars.printCarsStatus(), 1);

		assertThat(output()).contains("실행결과", "car1 :", "car2 :", "car3 :");
	}

	@Override protected void runMain() {}
}