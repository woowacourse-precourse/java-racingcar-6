package domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream mockOutput;
    private static final String SPERATOR = " : ";
    private static final String PROGRESS_BAR = "-";

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
