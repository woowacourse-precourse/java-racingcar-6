package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private Referee referee;
    private static final List<String> CAR_NAMES = Arrays.asList("aa", "bb", "cc");


    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    @DisplayName("단일 승자 테스트")
    void 단일_승자_테스트() {
        List<String> result = referee.getWinner(CAR_NAMES, Arrays.asList(1, 2, 3));
        assertThat(result).isEqualTo(Arrays.asList("cc"));
    }

    @Test
    @DisplayName("공동 승자 테스트")
    void 공동_승자_테스트() {
        List<String> result = referee.getWinner(CAR_NAMES, Arrays.asList(2, 2, 1));
        assertThat(result).isEqualTo(Arrays.asList("aa", "bb"));
    }
}