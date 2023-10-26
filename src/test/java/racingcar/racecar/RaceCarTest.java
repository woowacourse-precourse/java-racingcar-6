package racingcar.racecar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.CarName;
import racingcar.RaceCar;

public class RaceCarTest {

    @Test
    @DisplayName("RaceCar 대소비교")
    void raceCarCompareTest() {
        //given
        CarName name1 = new CarName("gun");
        CarName name2 = new CarName("tan");

        RaceCar car1 = new RaceCar(name1);
        RaceCar car2 = new RaceCar(name2);

        //when
        car1.moveForward();
        int compare1 = car1.compareTo(car2);
        car2.moveForward();
        car2.moveForward();
        int compare2 = car1.compareTo(car2);

        // then
        assertThat(compare1).isEqualTo(1);
        assertThat(compare2).isEqualTo(-1);
    }
}
