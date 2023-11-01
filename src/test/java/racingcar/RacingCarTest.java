package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.input.UserInput;
import racingcar.race.Handler;
import racingcar.utils.TestFixtureUtils;
import racingcar.vo.RacingInfo;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;


class RacingCarTest {

    @Mock
    private UserInput<RacingInfo> racingInfoInput= mock(UserInput.class);
    @Mock
    private Handler<RacingInfo,RacingInfo> racingInfoHandler= mock(Handler.class);

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(racingInfoInput, racingInfoHandler);
    }

    @Test
    @DisplayName("자동차 경주 시작 테스트")
    void run() {
        //given
        final RacingInfo racingInfo = TestFixtureUtils.generateRacingInfo(3, 5);
        given(racingInfoInput.input()).willReturn(racingInfo);
        //when
        racingCar.run();
        //then
        then(racingInfoHandler).should().execute(racingInfo);
        then(racingInfoInput).should().input();
    }

}