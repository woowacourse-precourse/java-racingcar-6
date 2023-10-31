package racingcar;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class RacingCarListTest {

    private RacingCarList racingCarList;

    @BeforeEach
    void createRacingCarList() {
        this.racingCarList = new RacingCarList("pobi,woni,jun");
    }

    @Test
    void executeOneStepAndGetMaxForward_Test_한번_실행_후_몇칸_움직여_졌는지_테스트() {
        MockedStatic<Randoms> randoms = mockStatic(Randoms.class);
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(5);
        racingCarList.executeOneStep();

        Assertions.assertThat(racingCarList.getMaxForward()).isEqualTo(1);
    }

    @Test
    void getWinnerList_우승자_목록_구하기_테스트() {
        List<String> winnerList = Arrays.asList("pobi", "woni", "jun");

        Assertions.assertThat(racingCarList.getWinnerList(0)).isEqualTo(winnerList);
    }


}
