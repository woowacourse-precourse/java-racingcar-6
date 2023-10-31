package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("만약 자동차들이 특정 횟수만큼 경쟁했다면 경쟁 전후의 해쉬코드는 달라져야 한다.")
    void compete() {
        Cars cars = new Cars("pobi,woni,jun");
        int gameTry = 100;

        int beforeHashCode = cars.hashCode();
        while (gameTry-- > 0) {
            cars.compete();
        }
        int afterHashCode = cars.hashCode();

        Assertions.assertThat(beforeHashCode).isNotEqualTo(afterHashCode);
    }
}
