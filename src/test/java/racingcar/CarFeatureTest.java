package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

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

}
