package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.Result;

public class ResultTest {
    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @Test
    void 거리출력_테스트() {
        int input1 = 3;
        int input2 = 7;
        int input3 = 12;

        String distance1 = result.printDistance(input1);
        String distance2 = result.printDistance(input2);
        String distance3 = result.printDistance(input3);

        assertThat(distance1).isEqualTo("---");
        assertThat(distance2).isEqualTo("-------");
        assertThat(distance3).isEqualTo("------------");
    }

    @Test
    void 자동차_이름과_거리_모두_출력_테스트() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("car1", 5));
        carList.add(new Car("car2", 13));
        carList.add(new Car("car3", 7));
        carList.add(new Car("car4", 2));
        carList.add(new Car("car5", 0));

        OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));

        result.printResult(carList);

        assertThat(result1.toString()).isEqualTo("car1 : -----" +
                System.lineSeparator() + "car2 : -------------" +
                System.lineSeparator() + "car3 : -------" +
                System.lineSeparator() + "car4 : --" +
                System.lineSeparator() + "car5 : " +
                System.lineSeparator() + System.lineSeparator()
        );
    }

    @Test
    void 우승자_출력_테스트() {
        List<Car> carList1 = new ArrayList<>();
        List<Car> carList2 = new ArrayList<>();
        carList1.add(new Car("car1", 5));
        carList1.add(new Car("car2", 13));
        carList1.add(new Car("car3", 7));
        carList2.add(new Car("car4", 2));
        carList2.add(new Car("car5", 2));
        carList2.add(new Car("car6", 3));

        OutputStream result1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result1));
        result.printWinner(carList1);

        OutputStream result2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result2));
        result.printWinner(carList2);

        assertThat(result1.toString()).isEqualTo("최종 우승자 : car2");
        assertThat(result2.toString()).isEqualTo("최종 우승자 : car4, car5");
    }
}
