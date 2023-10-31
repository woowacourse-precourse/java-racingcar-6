package racingcar.View;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private OutputView outputView;
    private List<Car> cars;
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        outputView = new OutputView();
        cars = Arrays.asList(new Car("jung", 4), new Car("yuju", 4), new Car("dong", 3));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 일회_사이클_출력화면() {
        outputView.result(cars);
        assertThat(output()).contains("jung : ----", "yuju : ----", "dong : ---");
    }

}