package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

public class OutputViewTest {

    private final OutputView outputView = OutputView.getInstance();
    PrintStream outputBackUp = System.out;

    @Test
    @DisplayName("차수별 경기 결과 출력")
    public void printRacingResultEachCountTest() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // 준비
        List<RacingCar> racingCarList = Arrays.asList(new RacingCar("pobi"), new RacingCar("woni"),
                new RacingCar("jun"));
        racingCarList.forEach(car -> {
            IntStream.rangeClosed(1, 10).forEach(count -> car.moveForwordOrNot());
        });
        // 실행
        outputView.printRacingResultEachCount(racingCarList);
        // 테스트
        assertThat(outputStream.toString().trim())
                .containsPattern("(?m)^[a-z]+\\s:\\s-+$");

        System.setOut(outputBackUp);
    }
}
