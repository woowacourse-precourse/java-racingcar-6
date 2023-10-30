package racingcar.view;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputViewTest {
    private OutputView outputView;
    private OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView = new OutputView();
    }

    @DisplayName("공동 우승자 출력 테스트")
    @Test
    void showWinnersTest() {
        List<Car> winners = Arrays.asList(new Car("test1"), new Car("test2"), new Car("test3"));
        String expectedMessage = "최종 우승자 : test1, test2, test3";

        outputView.showWinners(winners);

        assertThat(out.toString()).isEqualTo(expectedMessage);
    }

    @DisplayName("단독 우승자 출력 테스트")
    @Test
    void showWinnerTest() {
        List<Car> winners = Arrays.asList(new Car("test"));
        String expectedMessage = "최종 우승자 : test";

        outputView.showWinners(winners);

        assertThat(out.toString()).isEqualTo(expectedMessage);
    }
}