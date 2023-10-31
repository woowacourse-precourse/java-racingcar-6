package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarGroup;
import racingcar.global.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.global.Constant.RANDOM_NUMBER_THRESHOLD;

public class CarGroupTest {

    @Test
    @DisplayName("자동차 이름이 5자리 이상일 경우 예외 발생")
    void fromExceedCarNameLength() {
        assertThatThrownBy(() -> CarGroup.from("pobi,woni,juniper"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXCEED_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 중복 될 경우 예외 발생")
    void fromDuplicatedCarName() {
        assertThatThrownBy(() -> CarGroup.from("pobi,woni,jun,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 공백일 경우 예외 발생")
    void fromEmptyCarName() {
        assertThatThrownBy(() -> CarGroup.from("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("전진 및 한 라운드 결과 출력")
    void statusCorrectly() {
        assertRandomNumberInRangeTest(() -> {
            CarGroup carGroup = CarGroup.from("pobi,woni");
            carGroup.moveAllProbabilistically();
            assertThat(carGroup.getStatusAsString()).contains("pobi : -", "woni : ");
        }, RANDOM_NUMBER_THRESHOLD, RANDOM_NUMBER_THRESHOLD - 1);
    }

    @Test
    @DisplayName("우승자가 하나일 때 결과 출력")
    void winnerOnlyOne() {
        assertRandomNumberInRangeTest(() -> {
            CarGroup carGroup = CarGroup.from("pobi,woni");
            carGroup.moveAllProbabilistically();
            assertThat(carGroup.getWinnerAsString()).contains("pobi");
        }, RANDOM_NUMBER_THRESHOLD, RANDOM_NUMBER_THRESHOLD - 1);
    }

    @Test
    @DisplayName("우승자가 둘 이상일 때 결과 출력")
    void winnersMoreThanTwo() {
        assertRandomNumberInRangeTest(() -> {
            CarGroup carGroup = CarGroup.from("pobi,woni");
            carGroup.moveAllProbabilistically();
            assertThat(carGroup.getWinnerAsString()).contains("pobi", "woni");
        }, RANDOM_NUMBER_THRESHOLD, RANDOM_NUMBER_THRESHOLD);
    }
}
