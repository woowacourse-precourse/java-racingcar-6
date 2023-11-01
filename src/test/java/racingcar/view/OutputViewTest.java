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
import racingcar.dto.WinnerNameDto;

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

    @DisplayName("자동차 이름과 위치를 출력할 수 있다.")
    @Test
    void printCarsResults() {
        // given
        CarDto carDtoA = new CarDto("a", 0);
        CarDto carDtoB = new CarDto("b", 1);
        CarDto carDtoC = new CarDto("c", 2);
        CarDto carDtoD = new CarDto("d", 5);

        CarsDto carsDto = new CarsDto(List.of(carDtoA, carDtoB, carDtoC, carDtoD));

        // when
        outputView.printCarsResults(carsDto);

        // then
        assertThat(out.toString()).contains("""
                a :\s
                b : -
                c : --
                d : -----
                """);
    }

    @DisplayName("우승자 이름을 출력할 수 있다.")
    @Test
    void printWinners() {
        // given
        List<String> winnerName = List.of("a", "b", "c");
        WinnerNameDto winnerNameDto = new WinnerNameDto(winnerName);

        // when
        outputView.printWinners(winnerNameDto);

        // then
        assertThat(out.toString()).contains("최종 우승자 : a, b, c");
    }
}