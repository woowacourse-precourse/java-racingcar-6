package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Dto.CurrentRacingStatusDto;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.OutputView;

public class ViewTest {
    @Test
    void 각_단계별_위치_확인() {
        Car car1 = new Car("tony");
        Car car2 = new Car("Andy");
        Racing racing = new Racing(List.of(new Car[]{car1, car2}));
        car1.go(5);
        car1.go(5);
        car1.go(5);
        car2.go(5);
        car2.go(5);
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printCurrentStatus(new CurrentRacingStatusDto(racing));
        Assertions.assertThat(out.toString()).isEqualTo("tony : ---\nAndy : --\n");
    }

    @Test
    void 결과_반환() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        OutputView outputView = new OutputView();
//        outputView.printResult(List.of(new String[]{"tony", "poby"}));
        outputView.printResult(Arrays.asList("tony", "poby"));
        Assertions.assertThat(out.toString()).isEqualTo("최종 우승자 : tony, poby\n");
    }
}
