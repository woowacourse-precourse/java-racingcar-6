package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameValidatorTest {
    private RacingGameValidator racingGameValidator;

    @BeforeEach
    void setUp() {
        racingGameValidator = new RacingGameValidator();
    }

    @Test
    void 모든_자동차가_한번도_전진하지_않음() {
        List<Integer> resultList = new ArrayList<>(Arrays.asList(0, 0, 0));

        assertThatThrownBy(() -> racingGameValidator.validateGameTerminated(resultList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동한 자동차가 하나도 없어서 게임이 정상적으로 마무리되지 않았습니다.");
    }
}
