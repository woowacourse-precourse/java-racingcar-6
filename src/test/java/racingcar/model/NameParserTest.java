package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.CarNameParser;

public class NameParserTest {

    @Test
    void 쉼표로_자동차_이름_나누기() {
        // Given
        String input = "pobi,woni,jun";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni", "jun");

        // When
        CarNameParser carNameParser = new CarNameParser();
        List<String> resultCarNames = carNameParser.parseCarName(input);

        // Then
        assertThat(resultCarNames).isNotNull();
        assertThat(resultCarNames).hasSize(3);
        assertThat(resultCarNames).containsExactlyElementsOf(expectedCarNames);
    }
    @Test
    public void 자동차_이름_할당() {
        // Given
        CarNameParser carNameParser = new CarNameParser();
        List<String> carNameList = Arrays.asList("Tesla", "Ford", "car");

        // When
        List<Car> carList = carNameParser.stringToCarName(carNameList);

        // Then
        assertThat(carList).isNotNull();
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("Tesla");
    }
}
