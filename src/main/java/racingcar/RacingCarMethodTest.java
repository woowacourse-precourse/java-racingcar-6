package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarMethodTest {

    private ByteArrayOutputStream outputStreamCaptor;
    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void Car_move_Forward_결과_확인() {
        RacingCar car = new RacingCar("test");
        car.moveForward(4);
        assertThat(car).extracting("step").isEqualTo(1);
        car.moveForward(3);
        assertThat(car).extracting("step").isEqualTo(1);
    }

    @Test
    void Car_print_Current_Position_결과_확인(){
        RacingCar car = new RacingCar("test2");
        car.moveForward(4);
        car.moveForward(5);
        car.printCurrentPosition();
        assertThat(getOutput()).contains(car.name + " : --");
    }
    String getOutput(){
        return outputStreamCaptor.toString();
    }
}
