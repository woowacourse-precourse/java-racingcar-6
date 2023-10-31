package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.count.NoCountInputException;
import racingcar.exception.count.NonNumericStringException;
import racingcar.model.number.InputNumberGenerator;
import racingcar.model.number.RandomNumberGenerator;

class RacingTest {
    private static final String ONLY_NUMBER_INPUT_MESSAGE = "숫자만 입력하세요.";
    private static final String REQUEST_COUNT_INPUT_MESSAGE = "횟수를 입력하세요.";
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = RacingCars.createCars(new String[]{"car1", "car2"});
    }

    @Test
    void 숫자를_입력하지_않으면_예외발생() {
        String count = "다섯번";

        Assertions.assertThatThrownBy(() -> new Racing(racingCars, count))
                .isInstanceOf(NonNumericStringException.class)
                .hasMessage(ONLY_NUMBER_INPUT_MESSAGE);
    }

    @Test
    void 횟수가_공백이면_예외발생() {
        String count = "";

        Assertions.assertThatThrownBy(() -> new Racing(racingCars, count))
                .isInstanceOf(NoCountInputException.class)
                .hasMessage(REQUEST_COUNT_INPUT_MESSAGE);
    }

    @Test
    void 한_명_이상의_우승자_발생() {
        Racing racing = new Racing(racingCars, "1");
        racing.playRound(new InputNumberGenerator(4));
        List<String> winners = racing.getWinners();

        Assertions.assertThat(winners).hasSize(2);
    }

    @Test
    void 라운드가_남아있으면_true를_반환() {
        Racing racing = new Racing(racingCars, "4");
        racing.playRound(new RandomNumberGenerator());

        Assertions.assertThat(racing.isNotFinished()).isTrue();
    }
}