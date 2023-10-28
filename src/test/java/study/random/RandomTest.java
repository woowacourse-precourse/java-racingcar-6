package study.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.util.Randoms;

import static org.assertj.core.api.Assertions.*;


public class RandomTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("원하는 Random값이 나오면, 테스트를 통과한다.")
    public void randomSetsTest(final int expectValue) {
        // given
        MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class);
        // when
        BDDMockito.given(Randoms.getNumber()).willReturn(expectValue);
        // then
        assertThat(Randoms.getNumber()).isEqualTo(expectValue);
        //한 스레드에서 staticMocking 등록은 한번밖에 못하므로 close 해야한다.
        randoms.close();
    }

}
