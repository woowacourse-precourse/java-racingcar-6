package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Attempt;
import racingcar.domain.CarsFactory;
import racingcar.domain.Movement;

public class GameTest {
    private CarsFactory carsFactory;
    private Attempt attempt;
    private Movement movement;

    @BeforeEach
    public void setUp() {
        carsFactory = new CarsFactory();
        attempt = new Attempt();
        movement = new Movement();
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받기() {
        String input = "pobi,woni,jun";
        command(input);

        List<String> carNames = carsFactory.inputCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 시도_횟수_입력받아_저장하기() {
        command("5");

        assertThatCode(() -> attempt.saveAttemptNumber()).doesNotThrowAnyException();
    }

    @Test
    void 무작위_값_생성하기() {
        int RANDOM_NUMBER_MINIMUM = 0;
        int RANDOM_NUMBER_MAXIMUM = 9;

        int randomValue = movement.createRandomNumber();

        assertTrue(randomValue >= RANDOM_NUMBER_MINIMUM && randomValue <= RANDOM_NUMBER_MAXIMUM);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
