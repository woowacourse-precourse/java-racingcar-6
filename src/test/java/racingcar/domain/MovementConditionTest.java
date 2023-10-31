package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static racingcar.domain.MovementCondition.*;

@DisplayName("[MovementCondition Test] - Domain Layer")
class MovementConditionTest {

    private static MockedStatic<Randoms> randoms;

    @BeforeAll
    static void beforeSetUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        randoms.close();
    }


    @Nested
    @DisplayName("[canMovable Test - Validation to satisfy forward condition]")
    class movableTest {

        @Test
        @DisplayName("[Success] 전진 조건에 부합하여 true를 리턴합니다.")
        void Given_ForwardCondition_When_CanMovable_Then_ReturnTrue() {
            // given
            when(Randoms.pickNumberInRange(NUMBER_LOWER_BOUND_CONSTRAINT, NUMBER_UPPER_BOUND_CONSTRAINT))
                    .thenReturn(FORWARD_MOVEMENT_LOWER_BOUND_CONDITION);

            // when
            MovementCondition condition = MovementCondition.create();

            // then
            assertThat(condition.canMovable()).isTrue();
        }

        @Test
        @DisplayName("[Success] 정지 조건에 부합하여 false를 리턴합니다.")
        void Given_StopCondition_When_CanMovable_Then_ReturnFalse() {
            // given
            when(Randoms.pickNumberInRange(NUMBER_LOWER_BOUND_CONSTRAINT, NUMBER_UPPER_BOUND_CONSTRAINT))
                    .thenReturn(FORWARD_MOVEMENT_LOWER_BOUND_CONDITION - 1);

            // when
            MovementCondition condition = MovementCondition.create();

            // then
            assertThat(condition.canMovable()).isFalse();
        }
    }
}
