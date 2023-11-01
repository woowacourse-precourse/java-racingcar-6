package racingcar.domain;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ProgressTest {
    private static MockedStatic<Randoms> randoms;
    private static int SUCCESS_VALUE = 4;
    private static int FAIL_VALUE = 3;

    @BeforeAll
    public static void beforeTest() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterTest() {
        randoms.close();
    }

    @Test
    @DisplayName("랜덤값 4가 주어졌을 때, SUCCESS 스코어(1)를 반환합니다.")
    void getScoreSuccessTest() {
        //given
        given(Randoms.pickNumberInRange(Progress.MINIMUM_RANGE_NUMBER, Progress.MAXIMUM_RANGE_NUMBER))
                .willReturn(SUCCESS_VALUE);
        Progress testProgress = Progress.create();
        //when
        int testScore = testProgress.getScore();
        //then
        Assertions.assertThat(testScore).isEqualTo(Progress.SUCCESS);
    }

    @Test
    @DisplayName("랜덤값 3가 주어졌을 때, FAIL 스코어(0)를 반환합니다.")
    void getScoreFailTest() {
        //given
        given(Randoms.pickNumberInRange(Progress.MINIMUM_RANGE_NUMBER, Progress.MAXIMUM_RANGE_NUMBER))
                .willReturn(FAIL_VALUE);
        Progress testProgress = Progress.create();
        //when
        int testScore = testProgress.getScore();
        //then
        Assertions.assertThat(testScore).isEqualTo(Progress.FAIL);
    }
}