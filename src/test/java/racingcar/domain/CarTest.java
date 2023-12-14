package racingcar.domain;

import static org.mockito.Mockito.mockStatic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import racingcar.global.util.RandomNumberGenerator;

class CarTest {

    private static MockedStatic<RandomNumberGenerator> generator;

    @BeforeAll
    public static void beforeALl() {
        generator = mockStatic(RandomNumberGenerator.class);
    }

    @AfterAll
    public static void afterAll() {
        generator.close();
    }

    @Test
    @DisplayName("이동 조건을 만족하여 자동차가 이동한다.")
    void moveSuccessTest() {
        // given
        Car car = new Car(new Name("자동차"));
        BDDMockito.given(RandomNumberGenerator.generate(0, 9)).willReturn(5);

        // when
        car.move();

        // then
        Assertions.assertThat(car.moved()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 조건을 만족하지 못하여 자동차가 이동하지 않는다.")
    void moveFailTest() {
        // given
        Car car = new Car(new Name("자동차"));
        BDDMockito.given(RandomNumberGenerator.generate(0, 9)).willReturn(1);

        // when
        car.move();

        // then
        Assertions.assertThat(car.moved()).isEqualTo(0);
    }
}
