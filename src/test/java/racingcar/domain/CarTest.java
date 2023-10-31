package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private final int STEP = 3;
    private final int MOVE_CONDITION = 4;

    @BeforeEach
    void makeTestCar() {
        this.car = new Car("name");
    }

    @Test
    void 자동차_전진() {
        moveSteps();
        assertThat(car.getStatus()).isEqualTo(STEP);
    }

    private void moveSteps() {
        for (int i=0; i < STEP; i++)
            car.moveOrStop(MOVE_CONDITION);
    }

    @Test
    void 자동차_정지() {
        for (int i=0; i < STEP; i++)
            car.moveOrStop(MOVE_CONDITION - 1);
        assertThat(car.getStatus()).isEqualTo(0);
    }

    @Test
    void 자동차_이동상태_출력() {
        moveSteps();
        ByteArrayOutputStream outputStream = getByteArrayOutputStream();
        car.showStatus();
        assertThat(outputStream.toString()).contains("name : ---");
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }
}