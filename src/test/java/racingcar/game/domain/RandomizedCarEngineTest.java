package racingcar.game.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomizedCarEngineTest {
    @Test
    @DisplayName("Mocking 된 랜덤 값에 대해 올바른 결과를 반환한다")
    public void checkWorking_RandomTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    var engine = new RandomizedCarEngine();
                    assertThat(engine.checkWorking()).isEqualTo(false); // 0
                    assertThat(engine.checkWorking()).isEqualTo(false); // 1
                    assertThat(engine.checkWorking()).isEqualTo(false); // 2
                    assertThat(engine.checkWorking()).isEqualTo(false); // 3
                    assertThat(engine.checkWorking()).isEqualTo(true);  // 4
                    assertThat(engine.checkWorking()).isEqualTo(true);  // 5
                    assertThat(engine.checkWorking()).isEqualTo(true);  // 6
                    assertThat(engine.checkWorking()).isEqualTo(true);  // 7
                    assertThat(engine.checkWorking()).isEqualTo(true);  // 8
                    assertThat(engine.checkWorking()).isEqualTo(true);  // 9
                },
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }
}