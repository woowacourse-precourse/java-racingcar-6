package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.OutView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void printMoveResult_CARS_주어졌을때_결과_출력_단일(){
        //given
        List<Car> cars = Arrays.asList(new Car("car1", 3));

        //when
        OutView.printMoveResult(cars);

        //then
        String expected = "car1 : ---\n";
        assertThat(expected).isEqualTo(outputStreamCaptor.toString());
    }

    @Test
    void printMoveResult_CARS_주어졌을때_결과_출력_여러개(){
        //given
        List<Car> cars = Arrays.asList(new Car("car1", 3), new Car("car2", 2));

        //when
        OutView.printMoveResult(cars);

        //then
        String expected = "car1 : ---\n" + "car2 : --\n";
        assertThat(expected).isEqualTo(outputStreamCaptor.toString());
    }

    @Test
    public void printWinners_WINNERS_주어졌을때_출력_단일우승자(){
        //given
        List<Car> cars = Arrays.asList(new Car("car1", 3));

        //when
        OutView.printWinners(cars);

        //then
        String expected = "최종 우승자 : car1";
        assertThat(expected).isEqualTo(outputStreamCaptor.toString());
    }

    @Test
    public void printWinners_WINNERS_주어졌을때_출력_여러우승자(){
        //given
        List<Car> cars = Arrays.asList(new Car("car1", 3), new Car("car2", 3));

        //when
        OutView.printWinners(cars);

        //then
        String expected = "최종 우승자 : car1, car2";
    }
}
