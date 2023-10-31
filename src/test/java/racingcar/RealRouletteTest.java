package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

class RealRouletteTest {

    @Test
    void 룰렛은_우테코_라이브러리를_한번_사용한다() {
        // given
        RealRoulette realRoulette = new RealRoulette();

        // when
        try (MockedStatic<Randoms> mRandoms = mockStatic(Randoms.class)) {
            realRoulette.spin();

            // then
            mRandoms.verify(() -> Randoms.pickNumberInRange(0,9), times(1));
            mRandoms.verifyNoMoreInteractions();
        }
    }
}