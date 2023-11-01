package racingcar.domain;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.dto.CarStatusDto;

class CarTest {
    private static MockedStatic<Randoms> randoms;
    private static int SUCCESS_VALUE = 4;
    private static int FAIL_VALUE = 3;
    private static String INITAIL_NAME = "배달이";
    private static Integer INITAIL_SCORE = 0;


    @BeforeAll
    public static void beforeTest() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterTest() {
        randoms.close();
    }

    @Test
    void create() {
        //given
        String testName = "배달이";
        //when
        Car car = Car.create(testName);
        //then
        Assertions.assertThat(car.getName()).isEqualTo(testName);
    }

    @Nested
    @DisplayName("Progress 클래스와 Car 클래스의 tryPregress 함수를 테스트합니다.")
    class tryProgressTest {
        @DisplayName("전진에 성공할 시, progressScore에 1값이 추가됩니다.")
        @Test
        void tryProgressSuccess() {
            //given
            given(Randoms.pickNumberInRange(Progress.MINIMUM_RANGE_NUMBER, Progress.MAXIMUM_RANGE_NUMBER))
                    .willReturn(SUCCESS_VALUE);
            Car car = Car.create("배달이");
            //when
            car.tryProgress();
            //then
            Assertions.assertThat(car.getProgressScore()).isEqualTo(1);
        }

        @DisplayName("전진에 실패할 시, progressScore에 0값이 추가됩니다.")
        @Test
        void tryProgressFail() {
            //given
            given(Randoms.pickNumberInRange(Progress.MINIMUM_RANGE_NUMBER, Progress.MAXIMUM_RANGE_NUMBER))
                    .willReturn(FAIL_VALUE);
            Car car = Car.create("배달이");
            //when
            car.tryProgress();
            //then
            Assertions.assertThat(car.getProgressScore()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("배달이 car 객체를 생성한 후 dto를 생성할 시 초기값이 나와야 합니다.")
    void sendStatus() {
        //given
        Car car = Car.create(INITAIL_NAME);
        //when
        CarStatusDto carStatusDto = car.sendStatus();
        //then
        Assertions.assertThat(carStatusDto.name()).isEqualTo(INITAIL_NAME);
        Assertions.assertThat(carStatusDto.score()).isEqualTo(INITAIL_SCORE);
    }
}