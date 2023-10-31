package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputViewTest {
    private static final int NUMBER_OF_ADVANCE = 4;

    @Test
    @DisplayName("실행 결과 출력 테스트")
    void executionResultPrintTest() {
        //given
        OutputView outputView = new OutputView();

        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor)); // 이 후 출력은 captor에 저장됨

        List<String> nameList = List.of("pobi", "java");
        Cars cars = Cars.of(nameList);

        Car secondCar = cars.getCarList().get(1);
        secondCar.accumulate(NUMBER_OF_ADVANCE);

        //when
        outputView.printExecutionResult(cars);
        String output = captor.toString().trim();

        //then
        assertThat(output).contains("pobi : ", "java : -");
    }
}
