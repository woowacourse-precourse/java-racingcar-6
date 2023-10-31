package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import util.RandomGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;
    @BeforeEach
    public void setup() {
        car = new Car("TestCar");
    }

    @Test
    void 기본적인_getter_setter_테스트() {
        car.setName("NewName");
        assertThat(car.getName()).isEqualTo("NewName");
    }

    @Test
    void 자동차_초반_포지션_테스트() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void testDrive_드라이브_테스트() {
        car.drive();
        assertThat(car.getPosition()).isIn(0,1);
    }

    @Test
    void drive_여러번_실행시_특정_구간_테스트() {
        for (int i = 0; i < 10; i++) {
            car.drive();
        }
        assertThat(car.getPosition()).isBetween(0,10);
    }

    @Test
    void printPosition_자동차의_현재위치_반환() {
        car.drive();
        int position = car.getPosition();
        String expectedOutput = "TestCar : " + "-".repeat(position) + System.lineSeparator();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        car.printPosition();

        assertThat(out.toString()).isEqualTo(expectedOutput);
    }
}