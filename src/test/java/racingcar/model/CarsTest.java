package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class CarsTest {
    @Test
    void 문자열을_Car_리스트로_변환한다() {
        String carName = "pobi,woni,jun";
        Cars cars = new Cars(carName);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 전진한다() {
        String carNames = "pobi,woni,jun";
        Cars cars = new Cars(carNames);
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        assertRandomNumberInRangeTest(
                () -> {
                    cars.forward(numberGenerator);
                    assertAll(
                            () -> assertThat(cars.getCars().get(0).getPoint()).isEqualTo(1),
                            () -> assertThat(cars.getCars().get(1).getPoint()).isEqualTo(1),
                            () -> assertThat(cars.getCars().get(2).getPoint()).isEqualTo(0)
                    );

                },
                5, 4, 3
        );
    }

    @Test
    void 실행_결과를_응답한다() {
        String carNames = "pobi,woni,jun";
        Cars cars = new Cars(carNames);
        assertThat(cars.result()).isEqualTo("pobi : \nwoni : \njun : ");
    }
}