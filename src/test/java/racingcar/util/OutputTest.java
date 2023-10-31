package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Cars;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

public class OutputTest {
    @Test
    @DisplayName("MoveCount 결과 일치 비교")
    void correct_move_count_check() {
        Cars cars = new Cars("a,b");
        List<Integer> moveCountLists = new ArrayList<>();

        cars.getCarsList().forEach(car -> {
            car.moveOrStop(4);
        });

        cars.getCarsList().forEach(car -> {
            moveCountLists.add(car.getMoveCount());
        });

        assertThat(moveCountLists).containsOnly(1, 1);
    }

    @Test
    @DisplayName("printProcess 결과 일치 비교")
    void correct_print_process_check() {
        Cars cars = new Cars("a,b");

        cars.getCarsList().forEach(car -> {
            car.moveOrStop(4);
        });

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputView.printProcess(cars.getCarsList());

        String output = outputStream.toString();

        String expectedOutput = """
                a : -
                b : -
                                    
                """;

        System.setOut(System.out);

        String normalizedExpectedOutput = expectedOutput.replaceAll("\\s", "");
        String normalizedOutput = output.replaceAll("\\s", "");

        assertThat(normalizedExpectedOutput).isEqualTo(normalizedOutput);
    }

    @Test
    @DisplayName("Winner 일치 확인")
    void correct_winners_check() {
        Cars cars = new Cars("a,b");

        cars.getCarsList().forEach(car -> {
            car.moveOrStop(4);
        });

        List<String> winners = cars.getWinners();
        List<String> expectedWinners = Arrays.asList("a", "b");

        // Winners 의 인덱스 목록이 같은지 확인
        assertThat(winners).isEqualTo(expectedWinners);
    }
}
