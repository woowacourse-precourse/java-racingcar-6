package racingcar.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UiTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 시작문구를_출력한다() {
        String expectMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        new Ui().start();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }

    @Test
    void 시도횟수를_묻는_문구를_출력한다() {
        String expectMessage = "시도할 회수는 몇회인가요?";
        new Ui().askPlayCount();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }
}