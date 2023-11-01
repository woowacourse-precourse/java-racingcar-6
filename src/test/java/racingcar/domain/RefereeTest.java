package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private Referee referee;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        referee = new Referee();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        carList = Arrays.asList(car1, car2, car3);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차(우승자)를 식별하는 기능")
    void identifyWinner_가장_많이_이동한_자동차를_식별하는_기능() {

        carList.get(0).setForwardDistance(new StringBuffer("---"));
        carList.get(1).setForwardDistance(new StringBuffer("---"));
        carList.get(2).setForwardDistance(new StringBuffer("--"));

        List<Car> actual = referee.identifyWinner(carList);

        assertThat(actual).isEqualTo(Arrays.asList(carList.get(0), carList.get(1)));
    }
}