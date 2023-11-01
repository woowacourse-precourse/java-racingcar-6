package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.NumberConstant;
import racingcar.util.Utils;

class UtilsTest {

    @Test
    @DisplayName("시도할 횟수 검증 테스트")
    void 시도할_회수는_자연수만_가능합니다() {
        //given
        String zeroString = "0";
        String minusIntegerString = "-1";
        String naturalNumberString = "1";

        //when & then
        assertFalse(Utils.isNaturalNumber(zeroString));
        assertFalse(Utils.isNaturalNumber(minusIntegerString));
        assertTrue(Utils.isNaturalNumber(naturalNumberString));
    }

    @Test
    @DisplayName("랜덤 숫자 범위 양 끝값 포함 확인 테스트")
    void 랜덤_숫자_범위_테스트() {
        // given
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int randomNumber = Utils.getRandomNumber();
            randomNumbers.add(randomNumber);
        }

        //when & then
        assertThat(randomNumbers).contains(NumberConstant.MIN_RANDOM_RANGE, NumberConstant.MAX_RANDOM_RANGE);
    }
}