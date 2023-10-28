package racingcar.business;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 생성자로_부여한_자동차_이름_일치여부_확인() {
        String pobi = "pobi";

        Car pobisCar = new Car(pobi);

        assertThat(pobisCar.getName()).isEqualTo(pobi);
    }

}