package racingcar.View;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream newOut = new PrintStream(baos);
    @Test
    public void 자동차_이름_입력() {
        System.setOut(newOut);
        outputView.printInputRacingCar();
        assertThat(baos.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.setOut(System.out);
    }

    @Test
    public void 시도_횟수_입력() {
        System.setOut(newOut);
        outputView.printInputRacingCount();
        assertThat(baos.toString()).contains("시도할 회수는 몇회인가요?");
        System.setOut(System.out);
    }
}
