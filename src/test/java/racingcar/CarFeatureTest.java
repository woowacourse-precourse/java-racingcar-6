package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Round;

public class CarFeatureTest {

    @Test
    public void 차량_전진을_위한_무작위_값_추출() {
        Car car = new Car();
        int num = car.extract();

        assertTrue(num >= 0 && num <= 9);
    }

    @Test
    public void 차량_전진_조건에_따른_스코어_변화_확인() {
        Car car = new Car();
        String advancedScore1 = car.advance(4);
        String advancedScore2 = car.advance(0);
        String advancedScore3 = car.advance(9);

        assertThat(advancedScore1).isEqualTo("-");   // 전진 O
        assertThat(advancedScore2).isEqualTo("-");   // 전진 X
        assertThat(advancedScore3).isEqualTo("--");   // 전진 O

    }

    @Test
    public void 레이싱_1라운드_결과_저장() {
        Round round = new Round();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        round.init(Arrays.asList(car1, car2, car3), 3);
        round.play();

        assertThat(round.saveResult()).containsKey("car1");
        assertThat(round.saveResult()).containsKey("car2");
        assertThat(round.saveResult()).containsKey("car3");
    }

    @Test
    public void 레이싱_종료_회차_미달_시_상황() {
        Round round = new Round();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        round.init(Arrays.asList(car1, car2, car3), 3);
        assertThat(round.victory()).isEmpty();
        assertThat(round.saveResult()).containsValues("");  // 초기값으로 Map에 넣어둔 ""값이 저장된 상태
    }

}
