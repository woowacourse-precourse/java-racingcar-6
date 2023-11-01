package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.TestFixtureUtils;
import racingcar.vo.RacingInfo;

class RacingCarHandlerTest {

    private final RacingCarHandler racingCarHandler = new RacingCarHandler();

    @Test
    @DisplayName("execute 실행 테스트")
    void execute(){
        //given
        final RacingInfo racingInfo = TestFixtureUtils.generateRacingInfo(3, 5);
        //when
        RacingInfo execute = racingCarHandler.execute(racingInfo);
        //then
        Assertions.assertThat(execute.getRepeatCount()).isEqualTo(racingInfo.getRepeatCount());
        for(int i=0; i<execute.getCarCollection().getCarList().size(); i++){
            Assertions.assertThat(execute.getCarCollection().getCarList().get(i).getMoveCnt()).isGreaterThanOrEqualTo(0);
            Assertions.assertThat(execute.getCarCollection().getCarList().get(i).getMoveCnt()).isLessThanOrEqualTo(execute.getRepeatCount());
            Assertions.assertThat(execute.getCarCollection().getCarList().get(i).getName()).isEqualTo(racingInfo.getCarCollection().getCarList().get(i).getName());
        }
    }

}