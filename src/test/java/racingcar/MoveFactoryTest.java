package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoveFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"3, false", "4, true", "5, true"})
    void isMove는_4이상의_숫자면_true를_반환한다(int number, boolean isMove) {
        NumberGenerator numberGenerator = () -> number;
        MoveFactory moveFactory = new MoveFactory(numberGenerator);
        assertThat(moveFactory.isMove()).isEqualTo(isMove);
    }
}
