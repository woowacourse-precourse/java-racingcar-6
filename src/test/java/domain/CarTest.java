package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private Car car;
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream mockOutput;
    private static final String SPERATOR = " : ";
    private static final String PROGRESS_BAR = "-";

    @ParameterizedTest
    @ValueSource(strings = {
            "dakki",
            "pobi",
            "nan",
            "A",
    })
    void Car_정상생성(String input) {
        Car car = new Car(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "qwerty",
            "",
    })
    void Car_예외생성(String input) {
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toString_출력확인() {
        mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        String name = "daki";
        Car car = new Car(name);
        System.out.println(car);

        String printedContent = mockOutput.toString();

        assertThat(printedContent).isEqualTo(name + SPERATOR);
    }

    @Test
    void forward_전진여부_확인() {
        mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        String name = "daki";
        Car car = new Car(name);
        System.out.println(car);

        String printedContent = mockOutput.toString();
        assertThat(printedContent).isEqualTo(name + SPERATOR);

        car.forward();
        car.forward();
        System.out.println();
        printedContent = mockOutput.toString();
        assertThat(printedContent).isEqualTo(name + SPERATOR + PROGRESS_BAR + PROGRESS_BAR);
    }

    @Test
    void equals_동작확인() {
        String userA = "pobi";
        String userB = "daki";

        Car carA = new Car(userA);
        Car carB = new Car(userB);

        assertThat(carA).isEqualTo(carB);

        carA.forward();
        carB.forward();

        assertThat(carA).isEqualTo(carB);
    }
}
