package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;
import racingcar.domain.Attempt;
import racingcar.domain.CarsFactory;

public class GameTest {
    private CarsFactory carsFactory;
    private Attempt attempt;

    @BeforeEach
    public void setUp() {
        carsFactory = new CarsFactory();
        attempt = new Attempt();
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받기() {
        String input = "pobi,woni,jun";
        command(input);

        List<String> carNames = carsFactory.inputCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_이름_검증하기() {
        List<String> carNames1 = Arrays.asList("pobi", "woni", "jun");
        List<String> carNames2 = Arrays.asList("pobi", "woni", "");

        assertThatCode(() -> carsFactory.validateCarNames(carNames1)).doesNotThrowAnyException();
        assertThatThrownBy(() ->
                carsFactory.validateCarNames(carNames2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NAME_EXCEPTION);
    }

    @Test
    void 시도_횟수_입력받아_저장하기() {
        command("5");

        assertThatCode(() -> attempt.saveAttemptNumber()).doesNotThrowAnyException();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
