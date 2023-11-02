package mytest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.Output;

public class OutputTest {
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("레이스 결과를 출력하는 메소드 확인.")
    @Test
    void printResult() {
        Car car = new Car("aaa");
        Output.printRaceResult(car);

        String expectedOutput = "aaa :";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
    @DisplayName("우승자가 한명일 때 우승자 출력 테스트.")
    @Test
    void winnerOnly()throws NoSuchFieldException, IllegalAccessException {
        List<Car> cars=new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));

        setCarPosition(cars.get(0),1);
        setCarPosition(cars.get(1),5);

        String winner = Output.winner(cars);
        String expectedOutput="최종 우승자 : car2";
        assertEquals(expectedOutput,winner);

    }


    @DisplayName("우승자가 두명일 때 우승자 출력 테스트.")
    @Test
    void winners() throws NoSuchFieldException, IllegalAccessException {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        cars.add(new Car("car4"));

        setCarPosition(cars.get(0), 5);
        setCarPosition(cars.get(1), 5);
        setCarPosition(cars.get(2), 3);
        setCarPosition(cars.get(3), 2);

        String winners = Output.winner(cars);

        assertEquals("최종 우승자 : car1, car2", winners);
    }

    private void setCarPosition(Car car, int position) throws NoSuchFieldException, IllegalAccessException {
        Field positionField = car.getClass().getDeclaredField("position");
        positionField.setAccessible(true);
        positionField.setInt(car, position);
    }
}
