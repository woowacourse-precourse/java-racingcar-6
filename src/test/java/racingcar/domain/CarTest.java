package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void testInit() {
        car = new Car("pobi");
    }

    @Test
    void 지정한_이름으로_자동차가_생성_되는지_확인한다() {
        String expectedName = "pobi";

        String actualName = car.getName();

        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    void 자동차를_움직였을때_움직였는지_확인한다() {
        Integer expected = 1;

        car.move();
        Integer actual = car.getMoveCount();

        assertThat(actual).isEqualTo(expected);
    }
}