package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("성공 : 차량객체 생성")
    public void 차량객체_생성() {
        String input = "test";

        final Car car = new Car(input);

        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("성공 : 차량객체 생성 후 이름확인")
    public void 차량객체_생성_후_이름확인() {
        String input = "test";

        final Car car = new Car(input);

        assertThat(car.getName()).isEqualTo(input);
    }

    @Test
    @DisplayName("성공 : 차량객체 이동여부 확인")
    public void 차량객체_이동여부_확인() {
        String input = "test";

        final Car car = new Car(input);
        assertThat(car.run()).isEqualTo(car.getScore());
    }

    @Test
    @DisplayName("성공 : 차량객체 이동 후 출력 확인")
    public void 차량객체_이동_후_출력_확인() {
        String input = "test";

        final Car car = new Car(input);
        car.run();

        final String printFormat = String.format("%s : %s", car.getName(), "-".repeat(car.getScore()));
        assertEquals(printFormat, outContent.toString().trim());
    }

}