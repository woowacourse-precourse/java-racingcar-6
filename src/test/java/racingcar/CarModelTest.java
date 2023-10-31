package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.model.Car;

public class CarModelTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "5자초과한이름"})
    void 이름이_5를_초과할_때_예외를_던진다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(input));
    }
}
