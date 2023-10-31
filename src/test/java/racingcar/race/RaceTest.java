package racingcar.race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        this.race = new Race();
    }

    @Test
    void 차생성_5글자_이상() {
        String carName = "fiveOverLength";
        assertThatThrownBy(() -> race.carAdd(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 글자 수는 1이상 5이하여야 합니다.");
    }

    @Test
    void 차생성_빈이름_포함() {
        String carName = "";
        assertThatThrownBy(() -> race.carAdd(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 글자 수는 1이상 5이하여야 합니다.");
    }

    @Test
    void 차생성() {
        String[] carNames = {"1", "11", "111", "1111"};

        for (String carName : carNames) {
            assertThatCode(() -> race.carAdd(carName))
                    .doesNotThrowAnyException();
        }
    }
}