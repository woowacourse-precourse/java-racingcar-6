package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class CarControllerTest {
    private CarController carController = new CarController();

    @Test
    void 자동차_이름으로_자동차_생성(){
        String names = "pobi,woni,jun";
        ArrayList<Car> result = carController.createCars(names);

        assertThat(result.size()).isEqualTo(3);
    }
}
