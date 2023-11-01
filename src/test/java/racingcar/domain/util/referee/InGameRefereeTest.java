package racingcar.domain.util.referee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;
import racingcar.domain.util.referee.InGameReferee;

class InGameRefereeTest {
    @Test
    public void isBiggerLowerLimit_LOWER_LIMIT_보다_큰_수인지() throws Exception {
        InGameReferee inGameReferee = new InGameReferee();
        final int LOWER_LIMIT = inGameReferee.getLOWER_LIMIT_Fortest();
        int 작은수 = LOWER_LIMIT - 1;
        int 큰수 = LOWER_LIMIT + 1;

        boolean 작은result = inGameReferee.isBiggerLowerLimit(작은수);
        boolean 큰result = inGameReferee.isBiggerLowerLimit(큰수);
        boolean 같은result = inGameReferee.isBiggerLowerLimit(LOWER_LIMIT);

        assertThat(작은result).isEqualTo(false);
        assertThat(큰result).isEqualTo(true);
        assertThat(같은result).isEqualTo(true);
    }

    @Test
    public void findWinner_우승_판별() throws Exception {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> carList = List.of(car1, car2, car3);
        car2.forward();
        car3.forward();

        InGameReferee inGameReferee = new InGameReferee();
        List<Car> result = inGameReferee.findWinner(carList);

        assertThat(result).isEqualTo(List.of(car2, car3));
    }
}