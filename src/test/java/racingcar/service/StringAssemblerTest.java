package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class StringAssemblerTest {
    @DisplayName("실행 결과 문자열 조립 테스트")
    @Test
    void assembleStringTest() {
        Car car = new Car("붕붕이");

        car.move();
        car.move();

        assertEquals(StringAssembler.assembleRaceProgress(car), "붕붕이 : --");
    }
}
