package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_객체_생성() {
        Car carObj = new Car("vega");

        assertThat(carObj).isNotNull();
        assertThat(carObj.getCarName()).isEqualTo("vega");
    }

    @Test
    void 자동차이름_길이제한() {
        Car carObj = new Car("vega");
        int limitNameLength = 5;

        assertThat(carObj.getCarName().length()).isLessThanOrEqualTo(limitNameLength);
    }

    @Test
    void 자동차이름_공백검사() {
        Car carObj = new Car("vega");

        assertThat(carObj.getCarName()).doesNotContainAnyWhitespaces();
    }

    @Test
    void 랜덤수_정상적인지_확인() {
        int randNum = Randoms.pickNumberInRange(0, 9);

        assertThat(randNum).isBetween(0, 9);
    }

    @Test
    void 자동차_운행_전진멈춤확인() {
        Car carObj = new Car("vega");

        carObj.runCar();

        if (carObj.getForwardCount() == 0) {
            assertThat(carObj.getForwardCount()).isEqualTo(0);
        } else if (carObj.getForwardCount() == 1) {
            assertThat(carObj.getForwardCount()).isEqualTo(1);
        }
    }

    @Test
    void 자동차_운행_현재상태출력확인() {
        Car carObj = new Car("vega");
        String compareStringFirst = "vega : ";
        String compareStringSecond = "vega : -";

        carObj.runCar();

        if (carObj.getForwardCount() == 0) {
            assertThat(carObj.getPresentCondition()).isEqualTo(compareStringFirst);
        } else if (carObj.getForwardCount() == 1) {
            assertThat(carObj.getPresentCondition()).isEqualTo(compareStringSecond);
        }
    }
}
