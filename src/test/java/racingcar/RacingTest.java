package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    @DisplayName("initParticipants 이름 길이 초과 실패 테스트")
    void initParticipants_name_length_over_fail() {

        Racing racing = new Racing();
        String[] carNames = {"디카프리오", "레옹", "인텔리제이짱짱맨"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
