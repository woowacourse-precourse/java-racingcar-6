package racingcar.implementtest;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Output;

public class OutputTest {
    private Output output;

    @BeforeEach
    void initTest() {
        output = new Output();
    }

    @Test
    void 차수별_결과_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<Car> printList = Arrays.asList(new Car("pobi"), new Car("jiho"), new Car("java"));
        Car moveForwardCar = printList.get(0);
        moveForwardCar.moveForward();

        output.printRoundResult(printList);
        Assertions.assertThat(out.toString()).isEqualTo("pobi : -\njiho : \njava : \n");
    }

}
