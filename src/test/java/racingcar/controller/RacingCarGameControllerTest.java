package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;


class RacingCarGameControllerTest {

    RacingCarGameController racingCarGameController = new RacingCarGameController();

    @Test
    void 한줄로_입력_받은_자동차_이름_리스트_구분_기능() {
        List<String> carNameList = racingCarGameController.convertStringToCarList("벤츠,제네시스,소나타");
        assertThat(carNameList).contains("벤츠", "제네시스", "소나타");
    }

    @Test
    void 자동차들_전진_숫자_중_최댓값_찾는_기능() {
        Cars cars = new Cars();
        Map<String, Car> carMap = cars.getCars();
        Car car1 = new Car("벤츠");
        car1.setAdvanceCount(3);
        Car car2 = new Car("제네시스");
        car2.setAdvanceCount(5);

        carMap.put("벤츠", car1);
        carMap.put("제네시스", car2);
        int maxAdvanceCount = racingCarGameController.getMaxAdvanceCount(carMap);

        assertThat(maxAdvanceCount).isEqualTo(5);
    }
}