package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.util.FakeNumberGenerator;

@DisplayName("RacingCar 클래스")
class RacingCarTest {
    @Test
    @DisplayName("자동차 생성")
    void createRacingCar() {
        RacingCar car = new RacingCar("test");
        assertEquals("test", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Nested
    @DisplayName("자동차 이름에 대한 예외 처리")
    class RacingCarNameExceptionTest {
        @Test
        @DisplayName("자동차 이름이 비어 있을 경우 예외 발생")
        void carNameIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new RacingCar(""));
        }

        @Test
        @DisplayName("자동차 이름이 5자를 초과할 경우 예외 발생")
        void carNameIsOver5() {
            assertThrows(IllegalArgumentException.class, () -> new RacingCar("123456"));
        }
    }

    @Nested
    @DisplayName("자동차 moveOrStop 메소드 테스트")
    class RacingCarMoveOrStopTest {
        @Test
        @DisplayName("자동차가 전진하는 경우")
        void carMove() {
            RacingCar car = new RacingCar("test", new FakeNumberGenerator(9));
            car.moveOrStop();
            assertEquals(1, car.getPosition());
            car.moveOrStop();
            assertEquals(2, car.getPosition());
        }

        @Test
        @DisplayName("자동차가 멈추는 경우")
        void carStop() {
            RacingCar car = new RacingCar("test", new FakeNumberGenerator(2));
            car.moveOrStop();
            assertEquals(0, car.getPosition());
        }
    }

}
