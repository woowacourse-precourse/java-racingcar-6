package racingcar.domain;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {


    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"pobi",
            "juni",
            "jun"})
    void 자동차_생성_테스트(String name) {
        RacingCar racingCar = new RacingCar(name, 0);

        assertThat(racingCar).isNotNull();
    }

    @Test
    void 자동차_전진_테스트() {
        RacingCar racingCar1 = new RacingCar("juni", 1, bound -> 3);
        RacingCar racingCar2 = new RacingCar("huni", 1, bound -> 4);

        int round = 5;
        for (int i = 0; i < round; i++) {
            racingCar1.move();
            racingCar2.move();

        }
        assertThat(racingCar1.getMove()).isEqualTo(1);
        assertThat(racingCar2.getMove()).isEqualTo(6);
    }


}


/**
 * 1. 자동차의 이름을 입력하는 기능 ( o )
 * 2. 입력한 자동차를 쉼표(,)를 기준으로 나누는 기능 ( o )
 * 3. 자동차를 몇 번 이동할 것인지 입력하는 기능 ( o )
 * 4. 입력만큼 반복하는 기능 ( o )
 * 5. 랜덤한 값을 구하는 기능 ( o )
 * 6. 랜덤한 값이 4이상일 경우 자동차를 전진하는 기능 ( o )
 * 7. 자동차들의 현재 간 거리를 출력하는 기능 ( o )
 * 8. 우승자를 판별하는 기능 ( x )
 * 9. 우승자를 출력하는 기능 ( x )
 * 10. 우승자가 여럿일 경우 쉼표로 구분하는 기능 ( x )
 **/