package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.NumberConstraints;
import racingcar.application.NumberGenerator;

public class NavigatorTest {

    @DisplayName("생성된 숫자가 4 이상일 경우 GO를 반환한다.")
    @Test
    void decideMoveActionSuccessTest() {
        // given
        NumberGenerator numberGenerator =
                () -> Randoms.pickNumberInRange(NumberConstraints.MINIMUM_MOVABLE_NUMBER.getValue(), NumberConstraints.MAX_NUMBER.getValue());
        Navigator navigator = new Navigator(numberGenerator);

        // when
        MoveAction moveAction = navigator.decideMoveAction();

        // then
        Assertions.assertThat(moveAction).isEqualTo(MoveAction.GO);
    }

    @DisplayName("생성된 숫자가 3 이하일 경우 STOP을 반환한다.")
    @Test
    void decideMoveActionFailTest() {
        // given
        NumberGenerator numberGenerator =
                () -> Randoms.pickNumberInRange(NumberConstraints.MIN_NUMBER.getValue(), NumberConstraints.MINIMUM_MOVABLE_NUMBER.getValue() - 1);
        Navigator navigator = new Navigator(numberGenerator);

        // when
        MoveAction moveAction = navigator.decideMoveAction();

        // then
        Assertions.assertThat(moveAction).isEqualTo(MoveAction.STOP);
    }

}
