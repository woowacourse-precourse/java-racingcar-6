package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarsFactory;

public class GameTest {
    private CarsFactory carsFactory;

    @BeforeEach
    public void setUp() {
        carsFactory = new CarsFactory();
    }

    @Test
    void 자동차_이름을_쉼표로_구분하여_입력받기() {
        String input = "pobi,woni,jun";
        command(input);

        List<String> carNames = carsFactory.inputCarNames();

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
