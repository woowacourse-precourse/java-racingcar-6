package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGoingRandomNumberTest {
    @Test
    @DisplayName("랜덤 숫자가 범위 내에 있는지 테스트")
    void 랜덤수_생성_확인() {
        NumberGenerator numberGenerator = new CarGoingRandomNumber();
        int randomNumber = numberGenerator.generateRandomNumber(0, 9);
        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("랜덤 숫자가 범위를 벗어나는 테스트")
    void 랜덤수가_범위를_벗어나는경우(){
        NumberGenerator numberGenerator = new CarGoingRandomNumber();
        assertDoesNotThrow(() -> numberGenerator.generateRandomNumber(0, 10));
    }

}
