package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceRuleTest {

    @Test
    @DisplayName("이동 유무 반환 테스트")
    public void isMove() {
       RaceRule raceRule = () -> true;

       assertThat(raceRule.isMove()).isTrue();

       raceRule = () -> false;
       assertThat(raceRule.isMove()).isFalse();
    }

}