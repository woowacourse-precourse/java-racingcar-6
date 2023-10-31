package racingcar.unit.racer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.common.config.RacingCarRule;
import racingcar.racer.RacingCar;
import racingcar.util.Random;

class RacingCarTest {

    private static MockedStatic<Random> random;

    @BeforeAll
    static void beforeAll() {
        random = mockStatic(Random.class);
    }

    @AfterAll
    static void afterAll() {
        random.close();
    }

    @Nested
    @DisplayName("이름을 기반으로 경주 자동차 생성 시")
    class create {

        @DisplayName("성공적으로 생성한다.")
        @Test
        void success() {
            //given
            String name = "pobi";

            //when
            RacingCar racingCar = RacingCar.from(name);

            //then
            assertThat(racingCar.getName()).isEqualTo(name);
        }

        @DisplayName("이름이 비었다면 예외를 발생시킨다.")
        @Test
        void fail_EmptyName() {
            //given
            String name = "";
            //when then
            assertThatThrownBy(() -> RacingCar.from(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("이름의 길이가 " + RacingCarRule.MAX_RACING_CAR_NAME_LENGTH + " 초과라면 예외를 발생시킨다.")
        @Test
        void fail_InvalidNameLength() {
            //given
            String name = "1".repeat(RacingCarRule.MAX_RACING_CAR_NAME_LENGTH + 1);
            //when then
            assertThatThrownBy(() -> RacingCar.from(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("알파벳이나 숫자 외 문자가 이름에 있는 경우 예외를 발생시킨다.")
        @ValueSource(strings = {"!dov", "sd d", "dfe\ns"})
        @ParameterizedTest
        void fail_InvalidNameFormat(String name) {
            //given
            //when then
            assertThatThrownBy(() -> RacingCar.from(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("경주 자동차는 이동 시")
    class move {

        @DisplayName("숫자를 랜덤으로 뽑아 0~3이 나오면 움직이지 않는다.")
        @ValueSource(ints = {0, 1, 2, 3})
        @ParameterizedTest
        void stop(int number) {
            //given
            given(Random.getRandomNumberInRange(anyInt(), anyInt())).willReturn(number);
            RacingCar racingCar = RacingCar.from("stop");

            //when
            racingCar.move();

            //then
            assertThat(racingCar.getPosition()).isZero();
        }

        @DisplayName("숫자를 랜덤으로 뽑아 4~9가 나오면 전진한다.")
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @ParameterizedTest
        void forward(int number) {
            //given
            given(Random.getRandomNumberInRange(anyInt(), anyInt())).willReturn(number);
            RacingCar racingCar = RacingCar.from("go");

            //when
            racingCar.move();

            //then
            assertThat(racingCar.getPosition()).isEqualTo(1);
        }
    }
}