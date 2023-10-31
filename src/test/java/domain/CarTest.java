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

}