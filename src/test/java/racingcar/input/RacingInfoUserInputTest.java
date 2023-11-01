package racingcar.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import racingcar.utils.TestFixtureUtils;
import racingcar.vo.CarCollection;
import racingcar.vo.RacingInfo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RacingInfoUserInputTest {
    @Mock
    private UserInput<Integer> repeatCountUserInput= Mockito.mock(UserInput.class);
    @Mock
    private UserInput<CarCollection> carCollectionUserInput= Mockito.mock(UserInput.class);

    private RacingInfoUserInput racingInfoUserInput;

    @BeforeEach
    void setUp() {
        racingInfoUserInput = new RacingInfoUserInput(carCollectionUserInput,repeatCountUserInput);
    }

    @Test
    @DisplayName("RacingInfoUserInput 객체 생성 여부 테스트")
    void input(){
        //given
        final Integer repeatCount = TestFixtureUtils.generateRandomNumber();
        final Integer carCollectionSize = TestFixtureUtils.generateRandomNumber();
        final CarCollection carCollection = TestFixtureUtils.generateCarCollection(carCollectionSize);
        given(carCollectionUserInput.input()).willReturn(carCollection);
        given(repeatCountUserInput.input()).willReturn(repeatCount);
        //when
        final RacingInfo result = racingInfoUserInput.input();
        //then
        Assertions.assertThat(result.getCarCollection()).usingRecursiveComparison().isEqualTo(carCollection);
        Assertions.assertThat(result.getRepeatCount()).isEqualTo(repeatCount);
    }
}