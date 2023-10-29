package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.InputViewTestConstant.BLANK_VALUE;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.constant.InputViewTestConstant.CarNameTest;
import racingcar.constant.InputViewTestConstant.MovementTimeTest;

@DisplayName("자동차 경주 입력 테스트")
class InputViewTest {
    @Nested
    @DisplayName("경주할 자동차의 이름 입력 테스트")
    class InputCarNames extends NsTest {
        @Test
        @DisplayName("정상 작동")
        void success() {
            assertSimpleTest(
                    () -> {
                        run(CarNameTest.SUCCESSFUL_CAR_NAMES);
                        assertThat(output()).isEqualTo(CarNameTest.SUCCESSFUL_CAR_NAMES_LIST.toString());
                    }
            );
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("빈 값 테스트")
            void blankExceptionTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(BLANK_VALUE))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("5자 초과 값 테스트")
            void exceedLengthExceptionTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(CarNameTest.EXCEED_LENGTH_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("중복된 이름 테스트")
            void duplicatedCarNamesExceptionTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(CarNameTest.DUPLICATE_CAR_NAMES_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            System.out.println(inputView.getCarNames().toString());
        }

        @Nested
        @DisplayName("이동할 횟수 입력 테스트")
        class InputMovementTime extends NsTest {
            @Test
            @DisplayName("정상 작동")
            void success() {
                assertSimpleTest(
                        () -> {
                            run(MovementTimeTest.SUCCESSFUL_MOVEMENT_TIME);
                            assertThat(output()).isEqualTo(MovementTimeTest.SUCCESSFUL_MOVEMENT_TIME);
                        }
                );
            }

            @Nested
            @DisplayName("예외 테스트")
            class ExceptionTest {
                @Test
                @DisplayName("빈 값 테스트")
                void blankExceptionTest() {
                    assertSimpleTest(() ->
                            assertThatThrownBy(() -> runException(BLANK_VALUE))
                                    .isInstanceOf(IllegalArgumentException.class));
                }

                @Test
                @DisplayName("숫자가 아닌 값 테스트")
                void invalidTypeTest() {
                    assertSimpleTest(() ->
                            assertThatThrownBy(() -> runException(MovementTimeTest.INVALID_TYPE_MOVEMENT_TIME))
                                    .isInstanceOf(IllegalArgumentException.class));
                }
            }

            @Override
            protected void runMain() {
                InputView inputView = new InputView();
                System.out.println(inputView.getMovementTime());
            }
        }
    }
}