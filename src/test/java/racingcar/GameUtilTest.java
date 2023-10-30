package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameUtilTest {
    private GameUtil gameUtil;

    @BeforeEach
    void setUp() {
        gameUtil = new GameUtil(Constants.MIN_RANDOM_VALUE, Constants.MAX_RANDOM_VALUE);
    }

    @Test
    @DisplayName("잘못된 자동차 이름 입력 테스트")
    void setCarsNameValidateTest() {
        String carNames = "car1car2";
        assertThatThrownBy(() -> gameUtil.setCarsName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 반복 횟수 입력 테스트")
    void setRepeatNumberValidateTest() {
        String repeatNumber = "a";
        assertThatThrownBy(() -> gameUtil.setRepeatNumber(repeatNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("전진 테스트")
    void randomProgressTest() {
        GameUtil tmpGameUtil = new GameUtil(Constants.PROGRESS_LIMIT_NUMBER, Constants.PROGRESS_LIMIT_NUMBER);
        tmpGameUtil.setCarsName("car1,car2");
        tmpGameUtil.setRepeatNumber("1");

        assertThat(tmpGameUtil.randomProgress()).isEqualTo("car1 : -\ncar2 : -\n");
    }

    @Test
    @DisplayName("정지 테스트")
    void randomNoProgressTest() {
        GameUtil tmpGameUtil = new GameUtil(Constants.PROGRESS_LIMIT_NUMBER-1, Constants.PROGRESS_LIMIT_NUMBER-1);
        tmpGameUtil.setCarsName("car1,car2");
        tmpGameUtil.setRepeatNumber("1");

        assertThat(tmpGameUtil.randomProgress()).isEqualTo("car1 : \ncar2 : \n");
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void findWinnersTest() {
        GameUtil tmpGameUtil = new GameUtil(Constants.PROGRESS_LIMIT_NUMBER, Constants.PROGRESS_LIMIT_NUMBER);
        tmpGameUtil.setCarsName("car1,car2");
        tmpGameUtil.setRepeatNumber("1");
        tmpGameUtil.randomProgress();

        assertThat(tmpGameUtil.findWinners()).contains("최종 우승자 : car1, car2 ");
    }
}