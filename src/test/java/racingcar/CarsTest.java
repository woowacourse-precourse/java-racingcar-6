package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsTest {
    @Test
    @DisplayName("자동차 목록 생성")
    void Cars_객체_생성으로_사용자가_입력한_자동차_목록_생성() {
        // given
        String names = "dami,dayo,nabi";
        ArrayList<Car> testCars = new ArrayList<>();
        testCars.add(new Car("dami"));
        testCars.add(new Car("dayo"));
        testCars.add(new Car("nabi"));

        // when
        Cars cars = new Cars(names);

        // then
        for (int i = 0; i < testCars.size(); i++) {
            assertEquals(testCars.get(i).getName(), cars.getCar(i).getName());
        }
    }

    @Test
    @DisplayName("우승자 판별")
    void 가장_많이_전진한_자동차_목록_저장() {
        // given
        Cars cars = new Cars("dami,dayo,pobi,nabi");

        assertRandomNumberInRangeTest(() -> {
            for (Car car : cars) {
                car.moveOrStop();
            }
        }, 1, 2, 4, 4);

        // when
        List<String> winners = cars.findWinner(cars);
        // then
        assertThat(winners).contains("pobi", "nabi");
    }
}
