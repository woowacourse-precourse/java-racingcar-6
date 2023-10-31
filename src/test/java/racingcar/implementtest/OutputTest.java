package racingcar.implementtest;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.Output;

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
        Assertions.assertThat(out.toString()).isEqualTo("pobi : -\njiho : \njava : \n\n");
    }

    @Test
    void 우승자_결과_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<Car> winnerList = Arrays.asList(new Car("pobi"), new Car("jiho"), new Car("java"));

        output.printGameResult(winnerList);
        Assertions.assertThat(out.toString()).isEqualTo("최종 우승자 : pobi, jiho, java\n");
    }

}
