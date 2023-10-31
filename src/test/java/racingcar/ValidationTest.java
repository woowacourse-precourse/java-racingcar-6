package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void isNullTest() {
        final List<String> emptyList = new ArrayList<>();

        assertThatThrownBy(() -> Validation.isNull(emptyList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다. 게임을 종료합니다.");
    }

    @Test
    void isOverFiveTest() {
        // 변수이름이 너무 특징적이지 않다...?
        final List<String> overFiveList = Arrays.asList("car", "raceis", "fun");

        assertThatThrownBy(() -> Validation.isOverFive(overFiveList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 5자를 초과하였습니다. 게임을 종료합니다.");
    }

    @Test
    void isOverlapTest() {
        final List<String> overlappingList = Arrays.asList("start", "car", "race", "start");

        assertThatThrownBy(() -> Validation.isOverlapping(overlappingList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 입력값이 있습니다. 게임을 종료합니다.");
    }
}