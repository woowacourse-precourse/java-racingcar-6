package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.GameCount;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameCountTest {

    @ParameterizedTest
    @DisplayName("게임 진행 횟수가 1이상, 20이하가 아니라면 GameCount 생성에 실패한다.")
    @ValueSource(ints = {
            -1,
            0,
            21
    })
    void createGameCount_intCount_ThrowIllegalArgumentException(int gameCount) {
        assertThatThrownBy(() -> new GameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주 진행 횟수는 1회 이상, 20회 이하여야 합니다.");
    }

}
