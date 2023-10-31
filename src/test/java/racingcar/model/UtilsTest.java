package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Utils;

class UtilsTest {
    @Test
    @DisplayName("시도할 횟수 검증 테스트")
    void 시도할_회수는_자연수만_가능합니다() {
        assertFalse(Utils.isNaturalNumber("-1"));
        assertFalse(Utils.isNaturalNumber("0"));
        assertFalse(Utils.isNaturalNumber("1.5"));
    }

    @Test
    @DisplayName("랜덤 숫자 범위 양 끝값 포함 확인 테스트")
    void 랜덤_숫자_범위_테스트() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int randomNumber = Utils.getRandomNumber();
            randomNumbers.add(randomNumber);
        }
        assertThat(randomNumbers).contains(0, 9);
    }
}