package entity;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import racingcar.entity.Car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Car Entity 테스트")
public class CarTest {
    private Car car;

    @BeforeEach
    public void initTest() {
        car = new Car("testCar");
    }

    @Test
    @DisplayName("Car Entity 생성에 성공한다.")
    public void createEntityTest() {
        assertAll(
                () -> assertThat(car.getCarName()).isEqualTo("testCar"),
                () -> assertThat(car.getLocation()).isEqualTo(0)
        );
    }

    @Nested
    @DisplayName("moveForward() 메소드 테스트")
    public class moveForwardTest {
        private final int failNumber = Randoms.pickNumberInRange(0, 3);
        private final int successNumber = Randoms.pickNumberInRange(4, 9);
        @Test
        @DisplayName("전진 조건에 부합하지 않아 전진에 실패한다.")
        public void failMoveForward() {
            // when
            car.moveForward(failNumber);

            // then
            assertThat(car.getLocation()).isEqualTo(0);
        }

        @Test
        @DisplayName("전진 조건에 부합하여 전진에 성공한다.")
        public void successMoveForward() {
            // when
            car.moveForward(successNumber);

            // then
            assertThat(car.getLocation()).isEqualTo(1);
        }
    }
}
