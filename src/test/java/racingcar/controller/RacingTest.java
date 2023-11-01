package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.InputViewTestConstant.BLANK_VALUE;
import static racingcar.constant.RacingTestConstant.RANDOM_NUMBERS_FIRST_ELEM;
import static racingcar.constant.RacingTestConstant.RANDOM_NUMBERS_REMAIN_ELEMS;
import static racingcar.constant.RacingTestConstant.SUCCESSFUL_CAR_NAMES;
import static racingcar.constant.RacingTestConstant.SUCCESSFUL_EXECUTION_RESULTS_1;
import static racingcar.constant.RacingTestConstant.SUCCESSFUL_EXECUTION_RESULTS_2;
import static racingcar.constant.RacingTestConstant.SUCCESSFUL_EXECUTION_RESULTS_3;
import static racingcar.constant.RacingTestConstant.SUCCESSFUL_FINAL_WINNERS;
import static racingcar.constant.RacingTestConstant.SUCCESSFUL_MOVEMENT_TIME;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.constant.InputViewTestConstant;
import racingcar.constant.InputViewTestConstant.CarNameTest;

@DisplayName("자동차 경주 테스트")
class RacingTest extends NsTest {
    @Test
    @DisplayName("정상 작동")
    void success() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(SUCCESSFUL_CAR_NAMES, SUCCESSFUL_MOVEMENT_TIME);
                    assertThat(output()).contains(SUCCESSFUL_EXECUTION_RESULTS_1, SUCCESSFUL_EXECUTION_RESULTS_2,
                            SUCCESSFUL_EXECUTION_RESULTS_3, SUCCESSFUL_FINAL_WINNERS);
                },
                RANDOM_NUMBERS_FIRST_ELEM, RANDOM_NUMBERS_REMAIN_ELEMS.stream().toArray(Integer[]::new)
        );
    }

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {
        @Nested
        @DisplayName("경주할 자동차의 이름 입력 테스트")
        class CarNamesTest {
            @Test
            @DisplayName("빈 값 테스트")
            void blankExceptionTest() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(() -> runException(BLANK_VALUE, SUCCESSFUL_MOVEMENT_TIME))
                                        .isInstanceOf(IllegalArgumentException.class),
                        RANDOM_NUMBERS_FIRST_ELEM, RANDOM_NUMBERS_REMAIN_ELEMS.stream().toArray(Integer[]::new)
                );
            }

            @Test
            @DisplayName("5자 초과 값 테스트")
            void exceedLengthExceptionTest() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(() -> runException(CarNameTest.EXCEED_LENGTH_TEST, SUCCESSFUL_MOVEMENT_TIME))
                                        .isInstanceOf(IllegalArgumentException.class),
                        RANDOM_NUMBERS_FIRST_ELEM, RANDOM_NUMBERS_REMAIN_ELEMS.stream().toArray(Integer[]::new)
                );
            }

            @Test
            @DisplayName("중복된 이름 테스트")
            void duplicatedCarNamesExceptionTest() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(
                                        () -> runException(CarNameTest.DUPLICATE_CAR_NAMES_TEST, SUCCESSFUL_MOVEMENT_TIME))
                                        .isInstanceOf(IllegalArgumentException.class),
                        RANDOM_NUMBERS_FIRST_ELEM, RANDOM_NUMBERS_REMAIN_ELEMS.stream().toArray(Integer[]::new)
                );
            }
        }

        @Nested
        @DisplayName("이동할 횟수 입력 테스트")
        class MovementTimeTest {
            @Test
            @DisplayName("빈 값 테스트")
            void blankExceptionTest() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(
                                        () -> runException(SUCCESSFUL_EXECUTION_RESULTS_1, SUCCESSFUL_EXECUTION_RESULTS_2,
                                                SUCCESSFUL_EXECUTION_RESULTS_3, BLANK_VALUE))
                                        .isInstanceOf(IllegalArgumentException.class),
                        RANDOM_NUMBERS_FIRST_ELEM, RANDOM_NUMBERS_REMAIN_ELEMS.stream().toArray(Integer[]::new)
                );
            }

            @Test
            @DisplayName("숫자가 아닌 값 테스트")
            void invalidTypeTest() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(
                                        () -> runException(SUCCESSFUL_EXECUTION_RESULTS_1, SUCCESSFUL_EXECUTION_RESULTS_2,
                                                SUCCESSFUL_EXECUTION_RESULTS_3,
                                                InputViewTestConstant.MovementTimeTest.INVALID_TYPE_MOVEMENT_TIME))
                                        .isInstanceOf(IllegalArgumentException.class),
                        RANDOM_NUMBERS_FIRST_ELEM, RANDOM_NUMBERS_REMAIN_ELEMS.stream().toArray(Integer[]::new)
                );
            }
        }
    }

    @Override
    protected void runMain() {
        Racing racing = new Racing();
        racing.startRace();
    }
}