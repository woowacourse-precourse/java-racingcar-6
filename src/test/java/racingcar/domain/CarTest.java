package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("이동한 거리 출력 테스트")
    @Test
    void showMoveDistanceTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Car car = new Car("test");
        String expected = "test : --\n";

        car.moveForward(6);
        car.moveForward(7);
        car.showMoveDistance();

        assertThat(out.toString()).isEqualTo(expected);
    }
}