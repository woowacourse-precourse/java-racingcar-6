package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;


class UserTest {
    @Test
    void 전진값_테스트() {
        try (MockedStatic<Randoms> randoms=mockStatic(Randoms.class)){
            User user = User.of("신예찬");
            given(Randoms.pickNumberInRange(0,9)).willReturn(5);
            user.decideProceed();
            assertThat(user.getProceedCount()).isEqualTo(1);
            assertThat(user.visualizeProgress()).isEqualTo(user.getName()+" : "+"-");
        }
    }
}