package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void 차들_결과_출력() {
        // given
        CarDto carDtoA = new CarDto("a", 1);
        CarDto carDtoB = new CarDto("b", 2);
        CarDto carDtoC = new CarDto("c", 3);
        CarDto carDtoD = new CarDto("d", 4);

        CarsDto carsDto = new CarsDto(List.of(carDtoA, carDtoB, carDtoC, carDtoD));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));


        // when
        outputView.printCarsResults(carsDto);

        // then
        assertThat(out.toString()).contains("a : -\n"
                                            + "b : --\n"
                                            + "c : ---\n"
                                            + "d : ----\n");
    }

    @Test
    void 우승자_출력() {
        // given
        List<String> winnerName = List.of("a", "b", "c");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        outputView.printWinners(winnerName);

        // then
        assertThat(out.toString()).contains("최종 우승자 : a, b, c");
    }
}