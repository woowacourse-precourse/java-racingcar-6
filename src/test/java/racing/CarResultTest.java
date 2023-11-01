package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.result.CarResult;

public class CarResultTest {
    @Test
    void getNameTest() {

        CarResult carResult = new CarResult("pobi", 5);

        String retrievedName = carResult.getName();

        assertThat(retrievedName).isEqualTo("pobi");
    }

    @Test
    void getDistanceMarkTest() {

        CarResult carResult = new CarResult("pobi", 5);

        String expectedDistanceMark = "-----";
        String retrievedDistanceMark = carResult.getDistanceMark();

        assertThat(retrievedDistanceMark).isEqualTo(expectedDistanceMark);
    }
}
