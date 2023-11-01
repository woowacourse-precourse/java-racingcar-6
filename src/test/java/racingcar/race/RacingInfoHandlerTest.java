package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import racingcar.utils.TestFixtureUtils;
import racingcar.vo.RacingInfo;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class RacingInfoHandlerTest {

    @Mock
    private RacingCarHandler racingCarHandler = mock(RacingCarHandler.class);
    @Mock
    private RacingResultHandler racingResultHandler = mock(RacingResultHandler.class);

    private RacingInfoHandler racingInfoHandler;

    @BeforeEach
    void setUp(){
        racingInfoHandler = new RacingInfoHandler(racingCarHandler, racingResultHandler);
    }

    @Test
    @DisplayName("execute 메소드 실행 테스트")
    void execute(){
        //given
        final RacingInfo racingInfo = TestFixtureUtils.generateRacingInfo(3, 5);
        given(racingCarHandler.execute(racingInfo)).willReturn(racingInfo);
        given(racingResultHandler.execute(racingInfo.getCarCollection())).willReturn(racingInfo.getCarCollection());
        //when
        final RacingInfo result = racingInfoHandler.execute(racingInfo);
        //then
        then(racingCarHandler).should().execute(racingInfo);
        then(racingResultHandler).should().execute(racingInfo.getCarCollection());
        Assertions.assertThat(result.getRepeatCount()).isEqualTo(racingInfo.getRepeatCount());
        Assertions.assertThat(result.getCarCollection()).usingRecursiveComparison().isEqualTo(racingInfo.getCarCollection());
    }


}