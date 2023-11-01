package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.InputManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    @Test
    void 차이름으로_리스트_생성() {
        String carNamesLine = "pobi,woni";
        String[] carNames = carNamesLine.split(",");

        InputManager inputManager = new InputManager();
        List<Car> carList = inputManager.makePlayerCarList(carNames);

        assertThat(carList.size()).isEqualTo(carNames.length);

        for (int i = 0; i < carList.size(); i++)
            assertThat(carList.get(i).getName()).isEqualTo(carNames[i]);
    }
}

