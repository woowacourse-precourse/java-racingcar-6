package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("가장 많이 이동한 자동차(우승자)를 식볋하는 기능")
    void identifyWinner_가장_많이_이동한_자동차를_식별하는_기능() {
        Referee referee = new Referee();
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.setForwardDistance(new StringBuffer("---"));
        car2.setForwardDistance(new StringBuffer("---"));
        car3.setForwardDistance(new StringBuffer("--"));
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        List<Car> actual = referee.identifyWinner(carList);

        assertThat(actual).isEqualTo(Arrays.asList(car1, car2));
    }
}