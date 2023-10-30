package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    
    @Test
    @DisplayName("중복된 이름의 자동차가 있을 경우 IllegalArgumentException 발생한다.")
    public void 중복된_이름의_자동차가_있을_경우_IllegalArgumentException_발생한다() {
        //given
        String duplicateCarNames = "pobi,pobi";

        //when & then
        assertThatThrownBy(() -> Cars.from(duplicateCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 리스트가 비어있을 경우 IllegalArgumentException 발생한다.")
    public void 자동차_리스트가_비어있을_경우_IllegalArgumentException_발생한다() {
        //given
        String emptyCarNames = ",";

        //when & then
        assertThatThrownBy(() -> Cars.from(emptyCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
