package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

class OutputViewTest {

    OutputView outputView = new OutputView();
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void open() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void close() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 위치 출력")
    void 차들_결과_출력() {
        // given
        CarDto carDtoA = new CarDto("a", 0);
        CarDto carDtoB = new CarDto("b", 1);
        CarDto carDtoC = new CarDto("c", 2);
        CarDto carDtoD = new CarDto("d", 5);

        CarsDto carsDto = new CarsDto(List.of(carDtoA, carDtoB, carDtoC, carDtoD));

        // when
        outputView.printCarsResults(carsDto);

        // then
        assertThat(out.toString()).contains("a : \n"
                + "b : -\n"
                + "c : --\n"
                + "d : -----\n");
    }

    @Test
    @DisplayName("우승자 이름 출력")
    void 우승자_출력() {
        // given
        List<String> winnerName = List.of("a", "b", "c");

        // when
        outputView.printWinners(winnerName);

        // then
        assertThat(out.toString()).contains("최종 우승자 : a, b, c");
    }
}